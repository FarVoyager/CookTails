package com.example.cooktails.screens

import com.example.cooktails.detailsFragment.DetailsFragment
import com.example.cooktails.mainFragment.MainFragment
import com.example.cooktails.model.Cocktail
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class AndroidScreens @Inject constructor(): IScreens {

    override fun main(): Screen = FragmentScreen { MainFragment.newInstance() }

    override fun details(clickedCocktail: Cocktail): Screen =
        FragmentScreen { DetailsFragment.newInstance(clickedCocktail)
    }
}