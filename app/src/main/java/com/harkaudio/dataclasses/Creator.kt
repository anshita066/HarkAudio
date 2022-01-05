import com.google.gson.annotations.SerializedName



data class Creator (

	@SerializedName("uid") val uid : String,
	@SerializedName("name") val name : String,
	@SerializedName("isVerified") val isVerified : Boolean
)