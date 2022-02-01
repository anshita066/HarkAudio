package com.harkaudio.fragments.search.clips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer

class ClipsViewModel : ViewModel(){
    var answerList = ArrayList<Answer>()

    private val _clipsItemLiveData = MutableLiveData<List<Answer>>()

    val clipsItemLiveData : LiveData<List<Answer>> = _clipsItemLiveData

    fun updateClips(newList: ArrayList<Answer>){
        answerList.clear()
        answerList.addAll(newList)

        _clipsItemLiveData.value = answerList
    }
}