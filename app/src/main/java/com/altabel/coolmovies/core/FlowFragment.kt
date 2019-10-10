package com.altabel.coolmovies.core

import androidx.annotation.CallSuper
import com.altabel.coolmovies.R
import com.altabel.coolmovies.di.DI
import com.altabel.coolmovies.di.module.FlowNavigationModule
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Scope
import javax.inject.Inject

abstract class FlowFragment : BaseFragment() {

    override val layoutRes = R.layout.fragment_flow

    override val parentFragmentScopeName = DI.SERVER_SCOPE

    protected val navigator by lazy {
        SupportAppNavigator(
            activity,
            childFragmentManager,
            R.id.flowContainer_fl
        )
    }

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.flowContainer_fl) as? BaseFragment

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    @CallSuper
    override fun installScopeModules(scope: Scope) {
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
    }

    override fun onResume() {
        super.onResume()

        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()

        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}