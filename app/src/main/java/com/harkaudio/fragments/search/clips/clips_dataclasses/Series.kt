package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Series (

	@SerializedName("_id") val _id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("questionDesignType") val questionDesignType : String,
	@SerializedName("sponsor") val sponsor : Sponsor,
	@SerializedName("titleSlug") val titleSlug : String
)