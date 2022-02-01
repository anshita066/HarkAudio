package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class AudiobookIntro (

	@SerializedName("introText") val introText : String,
	@SerializedName("endTime") val endTime : Int,
	@SerializedName("duration") val duration : Int,
	@SerializedName("startTime") val startTime : Int,
	@SerializedName("userId") val userId : String,
	@SerializedName("userName") val userName : String,
	@SerializedName("podcastName") val podcastName : String,
	@SerializedName("isIntroAutoGenerated") val isIntroAutoGenerated : Boolean,
	@SerializedName("contentURI") val contentURI : String
)