import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


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
