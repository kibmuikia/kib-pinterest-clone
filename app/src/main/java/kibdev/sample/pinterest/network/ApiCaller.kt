package kibdev.sample.pinterest.network

import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): NetworkResult<T> = withContext(dispatcher) {
    try {
        NetworkResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        Timber.e(throwable)
        throwable.printStackTrace()
        when (throwable) {
            is IOException -> NetworkResult.NetworkError
            is HttpException -> {
                NetworkResult.ServerError(throwable.code(), errorBodyConverter(throwable))
            }
            else -> {
                NetworkResult.ServerError(null)
            }
        }
    }
}

private fun errorBodyConverter(throwable: HttpException): ErrorResponse? = try {
    throwable.response()?.errorBody()?.charStream()?.let {
        val gson = GsonBuilder().create()
        gson.fromJson(it, ErrorResponse::class.java)
    }
} catch (exception: Exception) {
    Timber.e(exception)
    null
}