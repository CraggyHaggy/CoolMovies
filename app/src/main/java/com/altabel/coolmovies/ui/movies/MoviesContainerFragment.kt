package com.altabel.coolmovies.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import com.altabel.coolmovies.R
import com.altabel.coolmovies.core.BaseFragment
import com.altabel.coolmovies.core.Screens
import kotlinx.android.synthetic.main.fragment_movies_container.*
import ru.terrakok.cicerone.Router
import toothpick.Scope
import javax.inject.Inject

class MoviesContainerFragment : BaseFragment() {

    @Inject
    lateinit var router: Router

    override val layoutRes = R.layout.fragment_movies_container

    override fun installScopeModules(scope: Scope) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = MoviesPagerAdapter()
    }

    override fun onBackPressed() {
        router.exit()
    }

    private inner class MoviesPagerAdapter : FragmentPagerAdapter(
        childFragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

        override fun getItem(position: Int) = when (position) {
            0 -> Screens.MoviesScreen(true).fragment
            else -> Screens.MoviesScreen(false).fragment
        }

        override fun getCount() = 2

        override fun getPageTitle(position: Int) = when (position) {
            0 -> getString(R.string.movies_tab_title_popular)
            1 -> getString(R.string.movies_tab_title_favorite)
            else -> null
        }
    }
}