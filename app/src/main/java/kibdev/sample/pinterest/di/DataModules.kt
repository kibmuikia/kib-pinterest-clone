package kibdev.sample.pinterest.di

import kibdev.sample.pinterest.data.remote.UnsplashAPI
import kibdev.sample.pinterest.repository.UnsplashRepository
import kibdev.sample.pinterest.repository.UnsplashRepositoryImp
import kibdev.sample.pinterest.viewmodels.UnsplashViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

private val moduleApis: Module = module {
    single<UnsplashAPI> { get<Retrofit>().create() }
}

private val moduleUtils: Module = module {
    single<Job> { SupervisorJob() }
    single { CoroutineScope(Dispatchers.IO + get<Job>()) }
}

private val repositoryModule: Module = module {
    single<UnsplashRepository> { UnsplashRepositoryImp(get()) }
}

private val moduleViewModels: Module = module {
    viewModel { UnsplashViewModel(get()) }
}

val dataModules: List<Module> = listOf(
    moduleApis,
    moduleViewModels,
    moduleUtils,
    repositoryModule,
)