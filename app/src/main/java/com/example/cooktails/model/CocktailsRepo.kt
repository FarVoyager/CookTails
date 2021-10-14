package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CocktailsRepo @Inject constructor(private val api: IDataSource) : ICocktailsRepo {
    override fun getRandomCocktails(): Single<List<Cocktail>> {
        return api.getRandomCocktails().subscribeOn(Schedulers.io())
    }

    override fun getCocktailByName(cocktailName: String): Single<Cocktail> {
        return api.getCocktailByName(cocktailName)
    }

    override fun getCocktailsByIngredient(ingredient: String): Single<List<Cocktail>> {
        return api.getCocktailsByIngredient(ingredient)
    }

    override fun getOneRandomCocktail(): Single<Cocktail> {
        return api.getOneRandomCocktail()
    }
}