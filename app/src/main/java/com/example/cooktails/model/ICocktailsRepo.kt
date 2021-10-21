package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single

interface ICocktailsRepo {
    fun getRandomCocktails(): Single<List<Cocktail>>
    fun getCocktailByName(cocktailName: String): Single<List<Cocktail>>
    fun getCocktailsByIngredient(ingredient: String): Single<List<Cocktail>>
    fun getOneRandomCocktail(): Single<List<Cocktail>>
    fun getCachedCocktails(): Single<List<Cocktail>>
}