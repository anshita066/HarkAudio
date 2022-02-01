package com.harkaudio.fragments.search.profiles

import Member
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilesViewModel : ViewModel()  {

    var memberList = ArrayList<Member>()

    private val _profilesItemLiveData = MutableLiveData<List<Member>>()

    val profilesItemLiveData : LiveData<List<Member>> = _profilesItemLiveData

    fun updateProfiles(newList: ArrayList<Member>){
        memberList.clear()
        memberList.addAll(newList)

        _profilesItemLiveData.value = memberList
    }
}