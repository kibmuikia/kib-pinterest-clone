package kibdev.sample.pinterest.data.local.models

import com.google.gson.annotations.SerializedName

data class GetPhotosRequest(
    @SerializedName("page")
    val page: Int = 1,
    @SerializedName("per_page")
    val per_page: Int = 1,
    @SerializedName("order_by")
    val order_by: String = "latest"
)