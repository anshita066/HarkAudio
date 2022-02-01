package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class Question (

    @SerializedName("_id") val _id : String,
    @SerializedName("title") val title : String,
    @SerializedName("creator") val creator : Creator,
    @SerializedName("sponsor") val sponsor : Sponsor,
    @SerializedName("hidden") val hidden : Boolean
)