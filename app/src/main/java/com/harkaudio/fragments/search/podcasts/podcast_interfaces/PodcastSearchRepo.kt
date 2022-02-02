package com.harkaudio.fragments.search.podcasts.podcast_interfaces

import Podcast
import androidx.lifecycle.LiveData
import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail

interface PodcastSearchRepo {
    fun fetchPodcastSearch(
        from: Int,
        limit: Int,
        searchString: String,
    ): LiveData<List<EpisodeDetail>>

}