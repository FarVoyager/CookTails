package com.example.cooktails.model.room.cache

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.room.Database
import com.example.cooktails.model.room.RoomCocktail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailsCache @Inject constructor(private val db: Database): ICocktailsCache {
    override fun getCachedCocktails(): Single<List<Cocktail>> =
        Single.fromCallable {
            db.cocktailDao.getAll().map { roomCocktail ->
                Cocktail(roomCocktail.id, roomCocktail.name, roomCocktail.imageUrl, roomCocktail.category,
                roomCocktail.alcoholic, roomCocktail.glass, roomCocktail.recipe)
            }
        }

    override fun insertCocktailsToCache(cocktails: List<RoomCocktail>) {
        db.cocktailDao.insert(cocktails)
    }
}