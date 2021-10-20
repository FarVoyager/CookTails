package com.example.cooktails.model.room

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.RandomCocktailsResponse
import io.reactivex.rxjava3.core.Single

interface IResponseConverter {
    fun convertToList(receivedObject: Single<RandomCocktailsResponse>): Single<List<Cocktail>>
}