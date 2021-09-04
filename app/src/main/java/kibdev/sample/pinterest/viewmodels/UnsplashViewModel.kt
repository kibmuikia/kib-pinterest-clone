package kibdev.sample.pinterest.viewmodels

import androidx.lifecycle.ViewModel
import kibdev.sample.pinterest.repository.UnsplashRepository

class UnsplashViewModel(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    init {
        //
    }

    override fun onCleared() {
        super.onCleared()
        //
    }

    suspend fun getPhotos(
        page: Int = 1,
        per_page: Int = 1,
        order_by: String = "latest"
    ) = unsplashRepository.getPhotos(page, per_page, order_by)

}