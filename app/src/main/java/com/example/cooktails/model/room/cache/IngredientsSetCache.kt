package com.example.cooktails.model.room.cache

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.room.Database
import com.example.cooktails.model.room.RoomCocktail
import com.example.cooktails.model.room.RoomIngredientSet
import io.reactivex.rxjava3.core.Single
import java.lang.RuntimeException
import javax.inject.Inject

class IngredientsSetCache @Inject constructor(private val db: Database): IIngredientsSetCache {
    override fun getCachedIngredientSetByCocktail(cocktail: Cocktail): Single<RoomIngredientSet> =
        Single.fromCallable {
            val roomCocktail = cocktail.name?.let { db.cocktailDao.findByName(it) } ?: throw RuntimeException("no such cocktail in cache")
            db.ingredientSetDao.findForCocktail(roomCocktail.id)
        }


    override fun insertIngredientSetsToCache(ingredientSets: List<RoomIngredientSet>) {
        TODO("Not yet implemented")
    }

    override fun getCocktailByName(text: String): RoomCocktail? {
        TODO("Not yet implemented")
    }
}