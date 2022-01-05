package com.harkaudio.interfaces

import Question
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.harkaudio.interfaces.CustomParser
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SearchRepoImp : SearchRepo, CustomParser() {

    val baseURL = "https://beta-api.harkaudio.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Harkapi = retrofit.create(Harkapi::class.java)

    override fun fetchSearchHarkList(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Question>> {

        val fetchSearchResponse = MutableLiveData<List<Question>>()

//        val call: Call<List<Question>> = service.fetchFromSearch(from, limit, searchString, type)

        var questionArray: ArrayList<Question>

        service.fetchFromSearch(from, limit, searchString, type)
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    searchResponse: Call<Object>,
                    response: Response<Object>
                ) {

                    Log.d("Success", "Received callback")

                    if (response.isSuccessful) {

                        Log.d("Success", "Received callback : ${Gson().toJson(response.body())}")

                        //Logic for sending data to Custom parser for parsing
//
                        fetchSearchResponse.value = CustomParser().parseQuestion(Gson().toJson(response.body()))

                    }

                }

                override fun onFailure(call: Call<Object>, t: Throwable) {

                    Log.e("ERROR", t!!.message.toString())
                }

        })
        return fetchSearchResponse
        }


}

