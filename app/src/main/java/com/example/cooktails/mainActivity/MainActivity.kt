package com.example.cooktails.mainActivity

import android.os.Bundle
import com.example.cooktails.di.AbsActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.ktx.moxyPresenter

class MainActivity : AbsActivity(), ActivityView {

    private val navigator = AppNavigator(this, android.R.id.content)
    private val presenter by moxyPresenter { ActivityPresenter(router, androidScreens) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}