package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/randomselection.php")
    fun getRandomCocktails(): Single<RandomCocktailsResponse>

    @GET("/search.php?i={cocktailName}")
    fun getCocktailByName(@Path("cocktailName") cocktailName: String): Single<Cocktail>

    @GET("/filter.php?i={ingredientName}")
    fun getCocktailsByIngredient(@Path("ingredientName") ingredientName: String): Single<List<Cocktail>>

    @GET("/random.php")
    fun getOneRandomCocktail(): Single<Cocktail>
}