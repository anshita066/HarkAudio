package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class PodcastIntro (

	@SerializedName("introText") val introText : String,
	@SerializedName("endTime") val endTime : Double,
	@SerializedName("duration") val duration : Double,
	@SerializedName("startTime") val startTime : Int,
	@SerializedName("userId") val userId : String,
	@SerializedName("userName") val userName : String,
	@SerializedName("contentURI") val contentURI : String,
	@SerializedName("podcastName") val podcastName : String,
	@SerializedName("isIntroAutoGenerated") val isIntroAutoGenerated : Boolean,
	@SerializedName("pollyIntro") val pollyIntro : Boolean
)