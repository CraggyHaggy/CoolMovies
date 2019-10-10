package com.altabel.coolmovies.app

import android.os.Bundle
import arellomobile.moxy.MvpAppCompatActivity
import com.altabel.coolmovies.R
import com.altabel.coolmovies.app.presentation.AppPresenter
import com.altabel.coolmovies.app.presentation.AppView
import com.altabel.coolmovies.core.FlowFragment
import com.altabel.coolmovies.di.DI
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Toothpick
import javax.inject.Inject

class AppActivity : MvpAppCompatActivity(), AppView {

    @InjectPresenter
    lateinit var presenter: AppPresenter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator =
        SupportAppNavigator(this, supportFragmentManager, R.id.appContainer_fl)

    private val currentFlowFragment: FlowFragment?
        get() = supportFragmentManager.findFragmentById(R.id.appContainer_fl) as? FlowFragment

    @ProvidePresenter
    fun providePresenter(): AppPresenter =
        Toothpick.openScope(DI.APP_SCOPE).getInstance(AppPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_app)

        if (savedInstanceState == null) {
            presenter.onAppStarted()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()

        super.onPause()
    }

    override fun onBackPressed() {
        currentFlowFragment?.onBackPressed() ?: presenter.onBackPressed()
    }
}