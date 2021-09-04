package kibdev.sample.pinterest.di

import kibdev.sample.pinterest.repository.UnsplashRepository
import kibdev.sample.pinterest.repository.UnsplashRepositoryImp
import org.koin.core.module.Module
import org.koin.dsl.module

private val repositoryModule: Module = module {

    single<UnsplashRepository> { UnsplashRepositoryImp(get(), get()) }

}

val dataModules: List<Module> = listOf(
    repositoryModule,
)