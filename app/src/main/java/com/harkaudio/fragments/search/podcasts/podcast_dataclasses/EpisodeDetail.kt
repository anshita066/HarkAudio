package com.harkaudio.fragments.search.podcasts.podcast_dataclasses

import com.google.gson.annotations.SerializedName

data class EpisodeDetail (

	@SerializedName("artistName") val artistName : String? =null,
	@SerializedName("audioUrl") val audioUrl : String? =null,
	@SerializedName("description") val description : String? =null,
	@SerializedName("duration") val duration : Int,
//	@SerializedName("endTime") val endTime : Int,
	@SerializedName("episodeSlug") val episodeSlug : String,
	@SerializedName("format") val format : String,
	@SerializedName("href") val href : String,
	@SerializedName("image") val image : String,
	@SerializedName("isClaimed") val isClaimed : Boolean,
	@SerializedName("name",alternate = ["title"]) val name : String? =null,
	@SerializedName("podcastSlug") val podcastSlug : String,
	@SerializedName("podcast_name") val podcaodcastImagest_name : String,
	@SerializedName("pubDate") val pubDate : Long,
//	@SerializedName("startTime") val startTime : Int,
	@SerializedName("type") val type : String,
	@SerializedName("imageHash") val imageHash : String,
	@SerializedName("hrefAudioUrl") val hrefAudioUrl : String,
	@SerializedName("clipAudioDuration") val clipAudioDuration : Int? =null,
	@SerializedName("clipAudioUrl") val clipAudioUrl : String? =null,
	@SerializedName("podcastImage") val podcastImage : String? =null,
	@SerializedName("podcastImageHash") val pHash : String? =null
)