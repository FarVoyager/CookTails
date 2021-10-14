package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single

interface ICocktailsRepo {
    fun getRandomCocktails(): Single<List<Cocktail>>
}