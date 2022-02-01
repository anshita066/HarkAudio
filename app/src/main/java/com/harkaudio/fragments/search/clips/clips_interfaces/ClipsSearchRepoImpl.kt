package com.harkaudio.fragments.search.clips.clips_interfaces

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class ClipsSearchRepoImpl : ClipsSearchRepo, ClipsParser() {

    private val baseURL = "https://beta-api.harkaudio.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: Clipsapi = retrofit.create(Clipsapi::class.java)

    override fun fetchSearchClips(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Answer>> {

        val fetchSearchResponse = MutableLiveData<List<Answer>>()

        service.fetchFromClipsSearch(from, limit, searchString, type)
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
                        fetchSearchResponse.value = ClipsParser().parseAnswer(Gson().toJson(response.body()).toString())

                    }

                }

                override fun onFailure(call: Call<Object>, t: Throwable) {

                    Log.e("ERROR", t!!.message.toString())
                }

            })
        return fetchSearchResponse
    }


}