package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class NoteCount (

	@SerializedName("root") val root : Int,
	@SerializedName("all") val all : Int,
	@SerializedName("ansComment") val ansComment : Int
)