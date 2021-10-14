package com.example.cooktails.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.cooktails.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MainFragment.newInstance()
}