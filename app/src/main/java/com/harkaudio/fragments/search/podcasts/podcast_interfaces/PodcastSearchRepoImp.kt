package com.harkaudio.fragments.search.podcasts.podcast_interfaces

import Expected
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.harkaudio.fragments.search.clips.clips_dataclasses.EpisodeDetail
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PodcastSearchRepoImp : PodcastSearchRepo, PodcastParser() {

    val baseURL = "https://beta-api.harkaudio.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Podcastapi = retrofit.create(Podcastapi::class.java)

    override fun fetchPodcastSearch(
        from: Int,
        limit: Int,
        searchString: String,
    ): LiveData<List<Expected>> {

        val fetchSearchResponse = MutableLiveData<List<Expected>>()

//        service.fetchPodcast(from, limit, searchString)
//            .enqueue(object : Callback<Object> {
//                override fun onResponse(
//                    searchResponse: Call<Object>,
//                    response: Response<Object>
//                ) {
//
//                    Log.d("Success", "Received callback")
//
//                    if (response.isSuccessful) {
//
//                        Log.d("Success", "Received callback : ${Gson().toJson(response.body())}")
//
//                        //Logic for sending data to Custom parser for parsing
//
//                        fetchSearchResponse.value = PodcastParser().parsePodcast(Gson().toJson(response.body()).toString())
//
//                    }
//
//                }
//
//                override fun onFailure(call: Call<Object>, t: Throwable) {
//
//                    Log.e("ERROR", t!!.message.toString())
//                }
//
//        })
        return fetchSearchResponse
        }


}


