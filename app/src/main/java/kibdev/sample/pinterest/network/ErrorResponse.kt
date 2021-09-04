package kibdev.sample.pinterest.network

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("errors")
    val error: List<Any>?
)