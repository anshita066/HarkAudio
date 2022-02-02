package com.harkaudio.fragments.search.podcasts

import Podcast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question

class PodcastViewModel : ViewModel()  {

    var arrayList = ArrayList<Podcast>()

    private val _podcastItemLiveData = MutableLiveData<List<Podcast>>()

    val podcastItemLiveData : LiveData<List<Podcast>> = _podcastItemLiveData

    fun updatePodcast(newList: ArrayList<Podcast>){
        arrayList.clear()
        arrayList.addAll(newList)

        _podcastItemLiveData.value = arrayList
    }
}