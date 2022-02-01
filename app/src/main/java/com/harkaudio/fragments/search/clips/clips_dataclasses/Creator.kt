package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName


data class Creator (

	@SerializedName("uid") val uid : String,
	@SerializedName("name") val name : String,
	@SerializedName("verified") val verified : Boolean,
	@SerializedName("isVerified") val isVerified : Boolean
)