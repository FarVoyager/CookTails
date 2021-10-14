package com.example.cooktails.di.modules

import com.example.cooktails.DetailsFragment
import com.example.cooktails.MainActivity
import com.example.cooktails.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CocktailsModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    fun bindDetailsFragment(): DetailsFragment

}