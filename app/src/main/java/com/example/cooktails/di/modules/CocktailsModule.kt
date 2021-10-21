package com.example.cooktails.di.modules

import com.example.cooktails.detailsFragment.DetailsFragment
import com.example.cooktails.mainActivity.MainActivity
import com.example.cooktails.mainFragment.MainFragment
import com.example.cooktails.model.ICocktailsRepo
import com.example.cooktails.model.room.RetrofitCocktailsRepo
import com.example.cooktails.model.room.cache.CocktailsCache
import com.example.cooktails.model.room.cache.ICocktailsCache
import dagger.Binds
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

    @Binds
    fun bindCocktailsRepo(cocktailsRepo: RetrofitCocktailsRepo): ICocktailsRepo

    @Binds
    fun bindCocktailsCache(cocktailsCache: CocktailsCache): ICocktailsCache

}