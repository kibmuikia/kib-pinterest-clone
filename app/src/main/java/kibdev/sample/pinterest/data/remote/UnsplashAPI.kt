package kibdev.sample.pinterest.data.remote

import kibdev.sample.pinterest.data.local.models.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashAPI {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 10,
        @Query("order_by") order_by: String = "latest",
        //@Body getPhotosRequest: GetPhotosRequest
    ): List<UnsplashPhoto>
    // https://api.unsplash.com/photos?page=1&per_page=15&order_by=latest

}