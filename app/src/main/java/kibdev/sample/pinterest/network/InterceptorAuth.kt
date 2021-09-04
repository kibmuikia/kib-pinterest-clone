package kibdev.sample.pinterest.network

import kibdev.sample.pinterest.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class InterceptorAuth : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var chainRequest = chain.request()
        chainRequest = chainRequest.newBuilder()
            .header("Accept-Version", "v1")
            .header("Authorization", "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
            .build()
        return chain.proceed(chainRequest)
    }

}