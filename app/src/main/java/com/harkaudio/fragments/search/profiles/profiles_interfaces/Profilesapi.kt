package com.harkaudio.fragments.search.profiles.profiles_interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Profilesapi {

    @GET("api/v0/entities/hark-search")
    fun fetchFromProfilesSearch(
        @Query("from") from: Int,
        @Query("limit") limit: Int,
        @Query("qs") searchString: String,
        @Query("type") type: String
    ): Call<Object>
}

