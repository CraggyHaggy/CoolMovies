package com.altabel.coolmovies.app.presentation

import com.altabel.coolmovies.core.BasePresenter
import com.altabel.coolmovies.core.ErrorHandler
import com.altabel.coolmovies.core.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<AppView>() {

    fun onAppStarted() {
        router.newRootScreen(Screens.MainFlow)
    }

    fun onBackPressed() {
        router.exit()
    }
}