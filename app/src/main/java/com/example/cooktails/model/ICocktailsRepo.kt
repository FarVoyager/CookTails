package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single

interface ICocktailsRepo {
    fun getRandomCocktails(): Single<RandomCocktailsResponse>
    fun getCocktailByName(cocktailName: String): Single<Cocktail>
    fun getCocktailsByIngredient(ingredient: String): Single<List<Cocktail>>
    fun getOneRandomCocktail(): Single<Cocktail>
}