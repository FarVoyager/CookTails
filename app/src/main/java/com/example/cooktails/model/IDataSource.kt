package com.example.cooktails.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    @GET("/randomselection.php")
    fun getRandomCocktail(): Single<List<Cocktail>>
}