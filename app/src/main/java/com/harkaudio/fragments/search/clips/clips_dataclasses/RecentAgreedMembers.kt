package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class RecentAgreedMembers (

	@SerializedName("uid") val uid : String,
	@SerializedName("name") val name : String
)