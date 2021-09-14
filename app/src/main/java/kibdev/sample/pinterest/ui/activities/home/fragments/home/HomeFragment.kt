package kibdev.sample.pinterest.ui.activities.home.fragments.home

import android.os.Bundle
import kibdev.sample.pinterest.R
import kibdev.sample.pinterest.databinding.FragHomeBinding
import kibdev.sample.pinterest.ui.base.BindingFragment

class HomeFragment : BindingFragment<FragHomeBinding>() {

    override val layoutResId: Int = R.layout.frag_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}