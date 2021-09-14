package kibdev.sample.pinterest.ui.activities.home

import android.os.Bundle
import android.os.PersistableBundle
import kibdev.sample.pinterest.R
import kibdev.sample.pinterest.databinding.ActivityHomeBinding
import kibdev.sample.pinterest.ui.base.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>() {

    override val layoutResId: Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}