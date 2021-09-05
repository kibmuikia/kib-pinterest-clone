package kibdev.sample.pinterest.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    requireActivity().toast(message, duration)
}

fun String.toTitleCase(): String = this.lowercase().split(" ").joinToString(" ") { string ->
    string.replaceFirstChar { char ->
        if (char.isLowerCase()) {
            char.titlecase(Locale.getDefault())
        } else {
            char.toString()
        }
    }
}