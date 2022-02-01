package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Links (

	@SerializedName("_id") val _id : Int,
	@SerializedName("alias") val alias : String,
	@SerializedName("link") val link : String
)