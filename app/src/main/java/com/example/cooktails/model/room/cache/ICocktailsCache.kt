package com.example.cooktails.model.room.cache

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.room.RoomCocktail
import io.reactivex.rxjava3.core.Single

interface ICocktailsCache {
    fun getCachedCocktails(): Single<List<Cocktail>>
    fun insertCocktailsToCache(cocktails: List<RoomCocktail>)
}