import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2022 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Member (

	@SerializedName("_id") val _id : Int,
	@SerializedName("onboarding") val onboarding : Onboarding,
	@SerializedName("name") val name : String,
	@SerializedName("uid") val uid : String,
	@SerializedName("description") val description : String,
	@SerializedName("creationDate") val creationDate : Long,
	@SerializedName("memberType") val memberType : Int,
	@SerializedName("notifiedFacebook") val notifiedFacebook : Boolean,
	@SerializedName("notifiedTwitter") val notifiedTwitter : Boolean,
	@SerializedName("_type") val _type : String,
	@SerializedName("agreedAnswerCount") val agreedAnswerCount : Int,
//	@SerializedName("karma") val karma : Karma,
	@SerializedName("createdQuestionCount") val createdQuestionCount : Int,
	@SerializedName("followingCount") val followingCount : Int,
	@SerializedName("followerCount") val followerCount : Int,
	@SerializedName("lastPlayedPlaylists") val lastPlayedPlaylists : List<LastPlayedPlaylists>,
	@SerializedName("trackClip") val trackClip : List<Int>,
	@SerializedName("trackClipAudioUrl") val trackClipAudioUrl : List<String>,
	@SerializedName("userName") val userName : String,
	@SerializedName("seenCategoryClips") val seenCategoryClips : List<String>,
	@SerializedName("seenClips") val seenClips : List<Int>,
	@SerializedName("seenCategory") val seenCategory : List<String>,
	@SerializedName("seenPlaylist") val seenPlaylist : List<String>,
	@SerializedName("hardFollow") val hardFollow : List<Int>,
	@SerializedName("forYouHarklistHref") val forYouHarklistHref : String,
	@SerializedName("forYouHarklistId") val forYouHarklistId : Int
)