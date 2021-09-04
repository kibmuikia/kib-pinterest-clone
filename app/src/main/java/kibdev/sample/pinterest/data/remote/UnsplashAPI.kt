package kibdev.sample.pinterest.data.remote

import kibdev.sample.pinterest.data.local.models.GetPhotosRequest
import kibdev.sample.pinterest.data.local.models.UnsplashPhoto
import retrofit2.http.Body
import retrofit2.http.GET

interface UnsplashAPI {

    @GET("photos")
    suspend fun getPhotos(@Body getPhotosRequest: GetPhotosRequest): List<UnsplashPhoto>

}