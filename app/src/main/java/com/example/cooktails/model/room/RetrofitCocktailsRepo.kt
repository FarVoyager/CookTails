package com.example.cooktails.model.room

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.ICocktailsRepo
import com.example.cooktails.model.IDataSource
import com.example.cooktails.model.room.cache.ICocktailsCache
import com.example.cooktails.model.room.networkStatus.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitCocktailsRepo @Inject constructor(
    private val networkStatus: INetworkStatus,
    private val api: IDataSource,
    private val converter: IResponseConverter,
    private val cocktailsCache: ICocktailsCache
) : ICocktailsRepo {

    override fun getCachedCocktails(): Single<List<Cocktail>> {
        return cocktailsCache.getCachedCocktails().subscribeOn(Schedulers.io())
    }

    override fun getCachedCocktailsByIngredient(ingredient: String): Single<List<Cocktail>> {
        return cocktailsCache.getCocktailsByIngredient(ingredient).subscribeOn(Schedulers.io())
    }

    override fun getRandomCocktails(): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                converter.convertToSingleList(api.getRandomCocktails())
                    .flatMap { cocktails ->
                        Single.fromCallable {
                            val roomCocktails = cocktails.map { cocktail ->
                                convertToRoom(cocktail)
                            }
                            cocktailsCache.insertCocktailsToCache(roomCocktails)
                            cocktails
                        }
                    }
            } else {
                println("Missing network connection, loading from local cache...")
                cocktailsCache.getRandomCachedCocktails()
            }
        }.subscribeOn(Schedulers.io())


    override fun getCocktailByName(cocktailName: String): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                converter.convertToSingleList(api.getCocktailByName(cocktailName))
                    .flatMap { cocktails ->
                        Single.fromCallable {
                            val roomCocktails = cocktails.map { cocktail ->
                                convertToRoom(cocktail)
                            }
                            cocktailsCache.insertCocktailsToCache(roomCocktails)
                            cocktails
                        }
                    }
            } else {
                println("Missing network connection, loading from local cache...")
                cocktailsCache.getCachedCocktails()
            }
        }.subscribeOn(Schedulers.io())

    override fun getCocktailsByIngredient(ingredient: String): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                converter.convertToSingleList(api.getCocktailsByIngredient(ingredient))
                    .flatMap { cocktails ->
                        Single.fromCallable {
                            val roomCocktails = cocktails.map { cocktail ->
                                convertToRoom(cocktail)
                            }
                            cocktailsCache.insertCocktailsToCache(roomCocktails)
                            cocktails
                        }
                    }
            } else {
                println("Missing network connection, loading from local cache...")
                cocktailsCache.getCachedCocktails()
            }
        }.subscribeOn(Schedulers.io())


    override fun getOneRandomCocktail(): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                converter.convertToSingleList(api.getOneRandomCocktail())
                    .flatMap { cocktails ->
                        Single.fromCallable {
                            val roomCocktails = cocktails.map { cocktail ->
                                convertToRoom(cocktail)
                            }
                            cocktailsCache
                            cocktailsCache.insertCocktailsToCache(roomCocktails)
                            cocktails
                        }
                    }
            } else {
                println("Missing network connection, loading from local cache...")
                cocktailsCache.getCachedCocktails()
            }
        }.subscribeOn(Schedulers.io())


    private fun convertToRoom(cocktail: Cocktail): RoomCocktail {
        return RoomCocktail(
            cocktail.id ?: "",
            cocktail.name ?: "",
            cocktail.imageUrl ?: "",
            cocktail.category ?: "",
            cocktail.alcoholic ?: "",
            cocktail.glass ?: "",
            cocktail.recipe ?: "",
            cocktail.strIngredient1 ?: "",
            cocktail.strIngredient2 ?: "",
            cocktail.strIngredient3 ?: "",
            cocktail.strIngredient4 ?: "",
            cocktail.strIngredient5 ?: "",
            cocktail.strIngredient6 ?: "",
            cocktail.strIngredient7 ?: "",
            cocktail.strIngredient8 ?: "",
            cocktail.strIngredient9 ?: "",
            cocktail.strIngredient10 ?: "",
            cocktail.strIngredient11 ?: "",
            cocktail.strIngredient12 ?: "",
            cocktail.strIngredient13 ?: "",
            cocktail.strIngredient14 ?: "",
            cocktail.strIngredient15 ?: "",
            cocktail.strMeasure1 ?: "",
            cocktail.strMeasure2 ?: "",
            cocktail.strMeasure3 ?: "",
            cocktail.strMeasure4 ?: "",
            cocktail.strMeasure5 ?: "",
            cocktail.strMeasure6 ?: "",
            cocktail.strMeasure7 ?: "",
            cocktail.strMeasure8 ?: "",
            cocktail.strMeasure9 ?: "",
            cocktail.strMeasure10 ?: "",
            cocktail.strMeasure11 ?: "",
            cocktail.strMeasure12 ?: "",
            cocktail.strMeasure13 ?: "",
            cocktail.strMeasure14 ?: "",
            cocktail.strMeasure15 ?: "",
        )
    }
}