package com.harkaudio.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harkaudio.dataclasses.Question

class HarklistViewModel : ViewModel()  {

    var questionList = ArrayList<Question>()

    private val _harklistItemLiveData = MutableLiveData<List<Question>>()

    val harklistItemLiveData : LiveData<List<Question>> = _harklistItemLiveData

    fun updateHarkList(newList: ArrayList<Question>){
        questionList.clear()
        questionList.addAll(newList)

        _harklistItemLiveData.value = questionList
    }
}