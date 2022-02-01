package com.example.apidemo.interfaces

import androidx.lifecycle.LiveData
import com.example.apidemo.dataclasses.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Harkapi {

    @GET("api/v0/entities/hark-search")
    fun fetchFromSearch(
        @Query("from") from: Int,
        @Query("limit") limit: Int,
        @Query("qs") searchString: String,
        @Query("type") type: String
    ): Call<Object>
}

