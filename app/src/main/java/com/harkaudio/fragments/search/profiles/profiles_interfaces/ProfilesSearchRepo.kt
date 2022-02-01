package com.harkaudio.fragments.search.profiles.profiles_interfaces

import Member
import androidx.lifecycle.LiveData

interface ProfilesSearchRepo {
    fun fetchProfilesSearch(
        from: Int,
        limit: Int,
        searchString: String,
        type: String
    ): LiveData<List<Member>>
}