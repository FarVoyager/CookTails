package com.example.cooktails.model.room.cache

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.room.RoomCocktail
import com.example.cooktails.model.room.RoomIngredientSet
import io.reactivex.rxjava3.core.Single

interface IIngredientsSetCache {
    fun getCachedIngredientSetByCocktail(cocktail: Cocktail): Single<RoomIngredientSet>
    fun insertIngredientSetsToCache(ingredientSets: List<RoomIngredientSet>)
    fun getCocktailByName(text: String): RoomCocktail?
}