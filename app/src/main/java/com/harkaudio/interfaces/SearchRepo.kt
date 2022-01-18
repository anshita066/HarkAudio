package com.example.apidemo.interfaces

import Creator
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.harkaudio.dataclasses.Question
import retrofit2.Call

interface SearchRepo {
    fun fetchSearchHarkList(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Question>>

}