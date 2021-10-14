package com.example.cooktails.presenter

import com.example.cooktails.screens.IScreens
import com.example.cooktails.view.ActivityView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ActivityPresenter(private val router: Router, private val screens: IScreens): MvpPresenter<ActivityView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.main())
    }

    fun backClicked() {
        router.exit()
    }
}