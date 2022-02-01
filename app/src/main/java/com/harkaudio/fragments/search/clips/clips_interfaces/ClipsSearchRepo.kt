package com.harkaudio.fragments.search.clips.clips_interfaces

import androidx.lifecycle.LiveData
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer

interface ClipsSearchRepo {

    fun fetchSearchClips(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Answer>>

}