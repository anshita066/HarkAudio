package com.harkaudio.fragments.search.podcasts.podcast_interfaces


import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.reflect.Array
import java.util.*

interface Podcastapi {

    @GET("api/v0/external/search-podcast?")
    fun fetchPodcast(
        @Query("from") from: Int,
        @Query("limit") limit: Int,
        @Query("q") searchString: String
    ): Call<List<EpisodeDetail>>
}

