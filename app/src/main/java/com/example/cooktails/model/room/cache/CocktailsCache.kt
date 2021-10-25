package com.example.cooktails.model.room.cache

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.room.Database
import com.example.cooktails.model.room.RoomCocktail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailsCache @Inject constructor(private val db: Database): ICocktailsCache {
    override fun getCachedCocktails(): Single<List<Cocktail>> =
        Single.fromCallable {
            db.cocktailDao.getAll().map {
                    roomCocktail ->
                getCocktail(roomCocktail)
            }
        }

    override fun getCocktailsByIngredient(ingredient: String): Single<List<Cocktail>> {
        TODO("Not yet implemented")
    }

    override fun insertCocktailsToCache(cocktails: List<RoomCocktail>) {
        db.cocktailDao.insert(cocktails)
    }

    private fun getCocktail(roomCocktail: RoomCocktail): Cocktail {
        return Cocktail(
            roomCocktail.id, roomCocktail.name, roomCocktail.imageUrl, roomCocktail.category,
            roomCocktail.alcoholic, roomCocktail.glass, roomCocktail.recipe,
            roomCocktail.strIngredient1,
            roomCocktail.strIngredient2,
            roomCocktail.strIngredient3,
            roomCocktail.strIngredient4,
            roomCocktail.strIngredient5,
            roomCocktail.strIngredient6,
            roomCocktail.strIngredient7,
            roomCocktail.strIngredient8,
            roomCocktail.strIngredient9,
            roomCocktail.strIngredient10,
            roomCocktail.strIngredient11,
            roomCocktail.strIngredient12,
            roomCocktail.strIngredient13,
            roomCocktail.strIngredient14,
            roomCocktail.strIngredient15,

            roomCocktail.strMeasure1,
            roomCocktail.strMeasure2,
            roomCocktail.strMeasure3,
            roomCocktail.strMeasure4,
            roomCocktail.strMeasure5,
            roomCocktail.strMeasure6,
            roomCocktail.strMeasure7,
            roomCocktail.strMeasure8,
            roomCocktail.strMeasure9,
            roomCocktail.strMeasure10,
            roomCocktail.strMeasure11,
            roomCocktail.strMeasure12,
            roomCocktail.strMeasure13,
            roomCocktail.strMeasure14,
            roomCocktail.strMeasure15,
            )
    }

    override fun clearAll() {
        db.cocktailDao.deleteAll()
    }
}