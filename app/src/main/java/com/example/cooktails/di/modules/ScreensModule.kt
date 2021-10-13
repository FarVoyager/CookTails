package com.example.cooktails.di.modules

import com.example.cooktails.screens.AndroidScreens
import com.example.cooktails.screens.IScreens
import dagger.Binds
import dagger.Module

@Module
interface ScreensModule {

    @Binds
    fun bindScreens(androidScreens: AndroidScreens): IScreens
}