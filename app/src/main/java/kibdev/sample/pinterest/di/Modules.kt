package kibdev.sample.pinterest.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.GsonBuilder
import kibdev.sample.pinterest.BuildConfig
import kibdev.sample.pinterest.network.InterceptorAuth
import kibdev.sample.pinterest.utils.Constants
import kibdev.sample.pinterest.viewmodels.UnsplashViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import org.koin.androidx.viewmodel.dsl.viewModel
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

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(interceptorAuth)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                .serializeNulls()
                .create()))
            .build()
    }

}

private val moduleViewModels: Module = module {
    viewModel { UnsplashViewModel(get()) }
}

val appModules: List<Module> = listOf(
    moduleNetworking,
    moduleViewModels
)