package com.harkaudio.dataclasses

import Creator
import CustomAttributes
import NoteCount
import Series
import Sponsor
import VideoShareUrls
import com.google.gson.annotations.SerializedName


data class Question(

	@SerializedName("_id") val id : Int,
	@SerializedName("creator") val creator : Creator,
	@SerializedName("title") val title : String,
	@SerializedName("communityId") val communityId : Int,
	@SerializedName("answerCount") val answerCount : Int,
	@SerializedName("noteCount") val noteCount : NoteCount,
//	@SerializedName("tags") val tags : List<String>,
//	@SerializedName("creationDate") val creationDate : Long,
//	@SerializedName("activeDate") val activeDate : Long,
//	@SerializedName("updateTime") val updateTime : Int,
	@SerializedName("allowSuggestion") val allowSuggestion : Boolean,
	@SerializedName("clipRuntime") val clipRuntime : Int,
	@SerializedName("totalruntime") val totalruntime : Double,
	@SerializedName("hidden") val hidden : Boolean,
	@SerializedName("color") val color :String,
	@SerializedName("customAttributes") val customAttributes : CustomAttributes,
	@SerializedName("href") val href : String,
	@SerializedName("_type") val _type : String,
	@SerializedName("recentAnswerIds") val recentAnswerIds : List<Int>,
	@SerializedName("videoShareUrls") val videoShareUrls : List<VideoShareUrls>,
	@SerializedName("series") val series : Series,
	@SerializedName("podcastImages") val podcastImages : List<String>,
	@SerializedName("podcastImagesHash") val podcastImagesHash : List<String>,
	@SerializedName("description") val description : String,
	@SerializedName("sponsor") val sponsor : Sponsor,
//	@SerializedName("likeCount") val likeCount : Int,
	@SerializedName("titleLower") val titleLower : String,
	@SerializedName("descriptionLower") val descriptionLower : String
)
