import com.google.gson.annotations.SerializedName
import com.harkaudio.fragments.search.clips.clips_dataclasses.Images
import com.harkaudio.fragments.search.clips.clips_dataclasses.Links

data class Sponsor (

    @SerializedName("_id") val _id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("images") val images : Images,
    @SerializedName("links") val links : List<Links>,
    @SerializedName("trackingLink") val trackingLink : String
)