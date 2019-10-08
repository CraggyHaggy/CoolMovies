package com.altabel.coolmovies.ui

import android.os.Bundle
import com.altabel.coolmovies.core.FlowFragment
import com.altabel.coolmovies.core.Screens
import com.altabel.coolmovies.extension.setLaunchScreen

class MoviesFlowFragment : FlowFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (childFragmentManager.fragments.isEmpty()) {
            navigator.setLaunchScreen(Screens.MoviesContainerScreen)
        }
    }
}