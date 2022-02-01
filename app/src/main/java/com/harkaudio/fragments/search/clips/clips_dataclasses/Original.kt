package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Original (

	@SerializedName("image") val image : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int
)