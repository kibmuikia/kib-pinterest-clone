package kibdev.sample.pinterest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kibdev.sample.pinterest.databinding.ActivityScrollingBinding
import kibdev.sample.pinterest.network.NetworkResult
import kibdev.sample.pinterest.utils.launchSafely
import kibdev.sample.pinterest.viewmodels.UnsplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private val unsplashViewmodel by viewModel<UnsplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        initGetPhotos()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initGetPhotos() {
        Timber.e(": init")
        lifecycleScope.launchSafely {
            Timber.e(": calling api photos")
            when (val getPhotosResponse = unsplashViewmodel.getPhotos()) {
                is NetworkResult.Success -> {
                    val numPhotos = getPhotosResponse.data.size
                    Timber.e(": got photos[ $numPhotos ]")
                    getPhotosResponse.data?.forEach { unsplashPhoto ->
                        Timber.e(": unsplashPhoto[ ${unsplashPhoto.toString()} ]")
                    }
                }
                is NetworkResult.NetworkError -> {
                    Timber.e(": Network error encountered")
                }
                is NetworkResult.ServerError -> {
                    Timber.e(": Server error encountered")
                }
            }
        }
    }
}