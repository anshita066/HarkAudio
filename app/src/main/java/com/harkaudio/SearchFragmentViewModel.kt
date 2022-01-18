package com.harkaudio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harkaudio.dataclasses.Question


class SearchFragmentViewModel: ViewModel() {

     lateinit var changedTextLiveData : MutableLiveData<String>

     public fun changeText(newText : String){
               changedTextLiveData.value =newText
     }
}