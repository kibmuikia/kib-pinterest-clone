package kibdev.sample.pinterest.utils

import kibdev.sample.pinterest.BuildConfig

object Constants {

    val BASE_URL = if (BuildConfig.BUILD_TYPE == "release") {
        "https://api.unsplash.com/"
    } else {
        "https://api.unsplash.com/"
    }

}