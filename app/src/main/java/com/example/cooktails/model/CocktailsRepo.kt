package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CocktailsRepo @Inject constructor(private val api: IDataSource) : ICocktailsRepo {
    override fun getRandomCocktails(): Single<List<Cocktail>> {
        return api.getRandomCocktail().subscribeOn(Schedulers.io())
    }
}