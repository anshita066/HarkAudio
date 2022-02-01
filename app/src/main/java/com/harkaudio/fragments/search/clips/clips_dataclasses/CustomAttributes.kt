package com.harkaudio.fragments.search.clips.clips_dataclasses

import com.google.gson.annotations.SerializedName

data class CustomAttributes (

    @SerializedName("podcast") val podcast : EpisodeDetail,
    @SerializedName("podcastIntro") val podcastIntro : PodcastIntro
)