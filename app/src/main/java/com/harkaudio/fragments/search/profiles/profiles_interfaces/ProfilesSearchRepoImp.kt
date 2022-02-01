package com.harkaudio.fragments.search.profiles.profiles_interfaces

import Member
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.harkaudio.fragments.search.podcasts.podcast_interfaces.Podcastapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfilesSearchRepoImp : ProfilesSearchRepo, ProfilesParser() {

    val baseURL = "https://beta-api.harkaudio.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Profilesapi = retrofit.create(Profilesapi::class.java)

    override fun fetchProfilesSearch(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Member>> {

        val fetchSearchResponse = MutableLiveData<List<Member>>()

        service.fetchFromProfilesSearch(from, limit, searchString, type)
            .enqueue(object : Callback<Object> {
                override fun onResponse(
                    searchResponse: Call<Object>,
                    response: Response<Object>
                ) {

                    Log.d("Success", "Received callback")

                    if (response.isSuccessful) {

                        Log.d("Success", "Received callback : ${Gson().toJson(response.body())}")

                        //Logic for sending data to Custom parser for parsing

                        fetchSearchResponse.value = ProfilesParser().parseProfiles(Gson().toJson(response.body()).toString())

                    }

                }

                override fun onFailure(call: Call<Object>, t: Throwable) {

                    Log.e("ERROR", t!!.message.toString())
                }

        })
        return fetchSearchResponse
        }


}

