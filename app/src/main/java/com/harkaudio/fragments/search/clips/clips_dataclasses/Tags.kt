package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Tags (

	@SerializedName("_id") val _id : Int,
	@SerializedName("name") val name : String
)