package kibdev.sample.pinterest.data.local.models

import com.google.gson.annotations.SerializedName

data class UnsplashPhoto(
    @SerializedName("id")
    val id: String,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("updated_at")
    val updated_at: String,
    @SerializedName("promoted_at")
    val promoted_at: String? = null,
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("color")
    val color: String = "#ffffff",
    @SerializedName("blur_hash")
    val blur_hash: String,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("alt_description")
    val alt_description: String? = null,
    @SerializedName("urls")
    val urls: UnsplashPhotoUrls,
    @SerializedName("links")
    val links: UnsplashPhotoLinks,
    @SerializedName("categories")
    val categories: List<String> = emptyList(),
    @SerializedName("likes")
    val likes: Int = 0,
    @SerializedName("liked_by_user")
    val liked_by_user: Boolean = false,
    @SerializedName("current_user_collections")
    val current_user_collections: List<String> = emptyList(),
    @SerializedName("user")
    val user: UnsplashPhotoUser,
)

data class UnsplashPhotoUrls(
    @SerializedName("raw")
    val raw: String? = null,
    @SerializedName("full")
    val full: String? = null,
    @SerializedName("regular")
    val regular: String? = null,
    @SerializedName("small")
    val small: String? = null,
    @SerializedName("thumb")
    val thumb: String? = null,
)

data class UnsplashPhotoLinks(
    @SerializedName("self")
    val self: String,
    @SerializedName("html")
    val html: String,
    @SerializedName("download")
    val download: String,
    @SerializedName("download_location")
    val download_location: String,
)

data class UnsplashPhotoUser(
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updated_at: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String? = null,
    @SerializedName("twitter_username")
    val twitter_username: String? = null,
    @SerializedName("portfolio_url")
    val portfolio_url: String? = null,
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("links")
    val links: UnsplashPhotoUserLinks,
    @SerializedName("profile_image")
    val profile_image: UnsplashPhotoUserProfileImage,
    @SerializedName("instagram_username")
    val instagram_username: String? = null,
    @SerializedName("total_collections")
    val total_collections: Int = 0,
    @SerializedName("total_likes")
    val total_likes: Int = 0,
    @SerializedName("total_photos")
    val total_photos: Int = 0,
    @SerializedName("accepted_tos")
    val accepted_tos: Boolean = false,
    @SerializedName("for_hire")
    val for_hire: Boolean = false,
    @SerializedName("social")
    val social: UnsplashPhotoUserSocial
)

data class UnsplashPhotoUserLinks(
    @SerializedName("self")
    val self: String? = null,
    @SerializedName("html")
    val html: String? = null,
    @SerializedName("photos")
    val photos: String? = null,
    @SerializedName("likes")
    val likes: String? = null,
    @SerializedName("portfolio")
    val portfolio: String? = null,
    @SerializedName("following")
    val following: String? = null,
    @SerializedName("followers")
    val followers: String? = null,
)

data class UnsplashPhotoUserProfileImage(
    @SerializedName("small")
    val small: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("large")
    val large: String? = null,
)

data class UnsplashPhotoUserSocial(
    @SerializedName("instagram_username")
    val instagram_username: String? = null,
    @SerializedName("portfolio_url")
    val portfolio_url: String? = null,
    @SerializedName("twitter_username")
    val twitter_username: String? = null,
    @SerializedName("paypal_email")
    val paypal_email: String? = null,
)