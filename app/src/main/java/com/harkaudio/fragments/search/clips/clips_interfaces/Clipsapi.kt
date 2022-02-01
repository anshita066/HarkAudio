package com.harkaudio.fragments.search.clips.clips_interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Clipsapi {

    @GET("api/v0/entities/hark-search")
    fun fetchFromClipsSearch(
        @Query("from") from: Int,
        @Query("limit") limit: Int,
        @Query("qs") searchString: String,
        @Query("type") type: String
    ): Call<Object>
}
