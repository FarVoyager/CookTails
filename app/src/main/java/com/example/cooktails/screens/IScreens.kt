package com.example.cooktails.screens

import com.example.cooktails.model.Cocktail
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun main(): Screen
    fun details(clickedCocktail: Cocktail): Screen
}