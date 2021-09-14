package kibdev.sample.pinterest.app

import android.app.Application
import kibdev.sample.pinterest.BuildConfig
import kibdev.sample.pinterest.di.appModules
import kibdev.sample.pinterest.di.dataModules
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber

open class KibTrest : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeTimber()
        initializeKoin()
    }

    private fun initializeTimber() = when {
        BuildConfig.DEBUG -> {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.methodName + "--" + element.lineNumber
                }
            })
        }
        else -> Timber.plant(Timber.DebugTree())
    }

    private fun initializeKoin() {
        try {
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                val modules = mutableListOf<Module>().apply {
                    addAll(appModules)
                    addAll(dataModules)
                }
                modules(modules)
            }
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }
    }

}