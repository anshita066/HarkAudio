package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName


data class Answer(
	@SerializedName("_id") val _id : String,
//	@SerializedName("community") val community : Community,
	@SerializedName("title") val title : String,
	@SerializedName("question") val question : Question,
//	@SerializedName("noteCount") val noteCount : NoteCount,
	@SerializedName("description") val description : String? = null,
	@SerializedName("creator") val creator : Creator,
	@SerializedName("creationDate") val creationDate : Long,
//	@SerializedName("activeDate") val activeDate : Float,
	@SerializedName("customAttributes") val customAttributes : CustomAttributes,
	@SerializedName("href") val href : String,
	@SerializedName("_type") val _type : String,
//	@SerializedName("earliestNoteIds") val earliestNoteIds : List<Int>,
//	@SerializedName("recentAgreedMembers") val recentAgreedMembers : List<RecentAgreedMembers>,
	@SerializedName("podcasts_image") val podcasts_image : String? = null,
	@SerializedName("podcasts_image_hash") val podcasts_image_hash : String? = null,
	@SerializedName("updateTime") val updateTime : String,
//	@SerializedName("tags") val tags : String,
	@SerializedName("type") val type : String,
//	@SerializedName("titleLower") val titleLower : String,
//	@SerializedName("descriptionLower") val descriptionLower : String,
//	@SerializedName("resultPriority") val resultPriority : Int
)