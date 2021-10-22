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
        return         Single.fromCallable {
            db.cocktailDao.findByIngredient(ingredient).map {
                    roomCocktail ->
                getCocktail(roomCocktail)
            }
        }

//        return         Single.fromCallable {
//            db.cocktailDao.findByIngredient(ingredient).map {
//                    roomCocktails ->
//                getCocktail(roomCocktails)
//            }
//        }
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

    private fun getCocktails(roomList: List<RoomCocktail>): List<Cocktail> {
        val cocktailList = mutableListOf<Cocktail>()
        for (i in roomList.indices) {
            cocktailList.add(
                Cocktail(
                    roomList[i].id, roomList[i].name, roomList[i].imageUrl, roomList[i].category,
                    roomList[i].alcoholic, roomList[i].glass, roomList[i].recipe,
                    roomList[i].strIngredient1,
                    roomList[i].strIngredient2,
                    roomList[i].strIngredient3,
                    roomList[i].strIngredient4,
                    roomList[i].strIngredient5,
                    roomList[i].strIngredient6,
                    roomList[i].strIngredient7,
                    roomList[i].strIngredient8,
                    roomList[i].strIngredient9,
                    roomList[i].strIngredient10,
                    roomList[i].strIngredient11,
                    roomList[i].strIngredient12,
                    roomList[i].strIngredient13,
                    roomList[i].strIngredient14,
                    roomList[i].strIngredient15,

                    roomList[i].strMeasure1,
                    roomList[i].strMeasure2,
                    roomList[i].strMeasure3,
                    roomList[i].strMeasure4,
                    roomList[i].strMeasure5,
                    roomList[i].strMeasure6,
                    roomList[i].strMeasure7,
                    roomList[i].strMeasure8,
                    roomList[i].strMeasure9,
                    roomList[i].strMeasure10,
                    roomList[i].strMeasure11,
                    roomList[i].strMeasure12,
                    roomList[i].strMeasure13,
                    roomList[i].strMeasure14,
                    roomList[i].strMeasure15
            ))
        }
        return cocktailList
    }

    override fun clearAll() {
        db.cocktailDao.deleteAll()
    }
}