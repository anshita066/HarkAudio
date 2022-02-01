package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Community (

	@SerializedName("_id") val _id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("href") val href : String
)