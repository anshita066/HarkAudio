package com.harkaudio.fragments.search.podcasts.podcast_interfaces

import Expected
import androidx.lifecycle.LiveData

interface PodcastSearchRepo {
    fun fetchPodcastSearch(
        from: Int,
        limit: Int,
        searchString: String,
    ): LiveData<List<Expected>>

}