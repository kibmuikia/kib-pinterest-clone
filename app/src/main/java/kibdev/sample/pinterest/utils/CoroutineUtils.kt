package kibdev.sample.pinterest.utils

import kotlinx.coroutines.*
import timber.log.Timber

fun CoroutineScope.launchSafely(
    block: suspend CoroutineScope.() -> Unit
): Job = this.launch(Dispatchers.Main) {
    try {
        block()
    } catch (cancellationException: CancellationException) {
        Timber.e(cancellationException)
    } catch (exception: Exception) {
        Timber.d(exception)
    }
}