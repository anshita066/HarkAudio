package com.harkaudio.fragments.search.podcasts.podcast_interfaces

import Podcast
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apidemo.interfaces.CustomParser
import com.google.gson.Gson
import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PodcastSearchRepoImp : PodcastSearchRepo{

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
    ): LiveData<List<EpisodeDetail>> {

        val fetchSearchResponse = MutableLiveData<List<EpisodeDetail>>()

        service.fetchPodcast(from, limit, searchString)
            .enqueue(object : Callback<List<EpisodeDetail>>{

                override fun onResponse(
                    call: Call<List<EpisodeDetail>>,
                    response: Response<List<EpisodeDetail>>
                ) {
                    if (response.isSuccessful) {

                        Log.d("Success", "Received podcast callback : ${Gson().toJson(response.body())}")

                        fetchSearchResponse.value = response.body()

                    }
                }

                override fun onFailure(call: Call<List<EpisodeDetail>>, t: Throwable) {
                    Log.e("ERROR", t!!.message.toString())

                }
            })
        return fetchSearchResponse
        }
}


