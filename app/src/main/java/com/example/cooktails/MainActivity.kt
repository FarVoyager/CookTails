package com.example.cooktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cooktails.databinding.ActivityMainBinding
import com.example.cooktails.di.AbsActivity
import com.example.cooktails.presenter.ActivityPresenter
import com.example.cooktails.view.BackButtonListener
import com.example.cooktails.view.MainScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.ktx.moxyPresenter

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, R.id.container)
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