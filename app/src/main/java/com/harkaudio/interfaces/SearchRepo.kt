package com.harkaudio.interfaces

import Creator
import Question
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call

interface SearchRepo {
    fun fetchSearchHarkList(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Question>>

}