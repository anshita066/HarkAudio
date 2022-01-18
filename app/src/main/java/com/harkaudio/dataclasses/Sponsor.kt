import com.google.gson.annotations.SerializedName

data class Sponsor (

	@SerializedName("_id") val _id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("images") val images : Images,
	@SerializedName("links") val links : List<Links>,
	@SerializedName("trackingLink") val trackingLink : String
)