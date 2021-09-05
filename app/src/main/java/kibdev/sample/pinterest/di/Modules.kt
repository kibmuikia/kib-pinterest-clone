package kibdev.sample.pinterest.di

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.GsonBuilder
import kibdev.sample.pinterest.BuildConfig
import kibdev.sample.pinterest.network.InterceptorAuth
import kibdev.sample.pinterest.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val moduleNetworking: Module = module {

    single {
        val interceptor = HttpLoggingInterceptor().apply {
            level = when (BuildConfig.BUILD_TYPE) {
                "release" -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.BODY
            }
        }
        val interceptorAuth = InterceptorAuth()

        val chuckerInterceptor = ChuckerInterceptor.Builder(androidContext())
            .collector(ChuckerCollector(androidContext()))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(interceptorAuth)
            .addInterceptor(chuckerInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .serializeNulls()
                        .create()
                )
            )
            .client(get())
            .build()
    }

}

val appModules: List<Module> = listOf(
    moduleNetworking,
)