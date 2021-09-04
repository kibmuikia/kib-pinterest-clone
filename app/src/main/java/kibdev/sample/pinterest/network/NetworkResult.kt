package kibdev.sample.pinterest.network

sealed class NetworkResult<out R> {

    data class Success<out T>(val data: T) : NetworkResult<T>()

    object NetworkError : NetworkResult<Nothing>()

    data class ServerError(
        val code: Int? = null,
        val errorBody: ErrorResponse? = null
    ) : NetworkResult<Nothing>()

}