package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName


data class Audiobook (

	@SerializedName("bookName") val bookName : String,
	@SerializedName("artistName") val artistName : String,
	@SerializedName("format") val format : String,
	@SerializedName("href") val href : String,
	@SerializedName("_type") val _type : String,
	@SerializedName("audiobookSlug") val audiobookSlug : String,
	@SerializedName("bookDescription") val bookDescription : String,
	@SerializedName("link") val link : String,
	@SerializedName("audiobookImageHash") val audiobookImageHash : String,
	@SerializedName("image") val image : String,
	@SerializedName("_id") val _id : String,
//	@SerializedName("pubDate") val pubDate : Int,
	@SerializedName("description") val description : String,
	@SerializedName("name") val name : String,
	@SerializedName("chapterHash") val chapterHash : String,
	@SerializedName("chapterSlug") val chapterSlug : String,
	@SerializedName("s3audioUrl") val s3audioUrl : String,
	@SerializedName("startTime") val startTime : Int,
	@SerializedName("endTime") val endTime : Int,
	@SerializedName("clipAudioDuration") val clipAudioDuration : Int,
	@SerializedName("clipAudioUrl") val clipAudioUrl : String
)