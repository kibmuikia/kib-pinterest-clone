package kibdev.sample.pinterest.repository

import kibdev.sample.pinterest.data.local.models.UnsplashPhoto
import kibdev.sample.pinterest.data.remote.UnsplashAPI
import kibdev.sample.pinterest.network.NetworkResult
import kibdev.sample.pinterest.network.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface UnsplashRepository {

    suspend fun getPhotos(
        page: Int = 1,
        per_page: Int = 10,
        order_by: String = "latest"
    ): NetworkResult<List<UnsplashPhoto>>

}

class UnsplashRepositoryImp(
    private val unsplashAPI: UnsplashAPI,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UnsplashRepository {

    override suspend fun getPhotos(
        page: Int,
        per_page: Int,
        order_by: String
    ) = safeApiCall(ioDispatcher) {
        return@safeApiCall unsplashAPI.getPhotos(
            page = page,
            per_page = per_page,
            order_by = order_by
        )
    }

}