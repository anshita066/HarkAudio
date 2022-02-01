package com.example.apidemo.interfaces

import androidx.lifecycle.LiveData
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question

interface SearchRepo {
    fun fetchSearchHarkList(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Question>>

}