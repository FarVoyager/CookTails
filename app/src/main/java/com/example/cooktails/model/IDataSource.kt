package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDataSource {
    @GET("/randomselection.php")
    fun getRandomCocktails(): Single<RandomCocktailsResponse>

    @GET("/search.php?")
    fun getCocktailByName(@Path("i") cocktailName: String): Single<RandomCocktailsResponse>

    @GET ("/filter.php?")
    fun getCocktailsByIngredient(@Query("i") ingredientName: String): Single<RandomCocktailsResponse>

    @GET("/random.php")
    fun getOneRandomCocktail(): Single<RandomCocktailsResponse>
}