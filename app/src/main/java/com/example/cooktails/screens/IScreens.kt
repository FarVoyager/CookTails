package com.example.cooktails.screens

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun main(): Screen
    fun details(): Screen
}