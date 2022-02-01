package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Images (

	@SerializedName("small") val small : Small,
	@SerializedName("original") val original : Original
)