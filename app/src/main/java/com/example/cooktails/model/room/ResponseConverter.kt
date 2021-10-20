package com.example.cooktails.model.room

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.IDataSource
import com.example.cooktails.model.RandomCocktailsResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ResponseConverter @Inject constructor() : IResponseConverter {

    override fun convertToList(receivedObject: Single<RandomCocktailsResponse>): Single<List<Cocktail>> {
        var list: List<Cocktail>? = mutableListOf()
        receivedObject.subscribe({
            list = it.response
        }, {
            println("Error converting response")
        })

        return Single.just(list)
    }

}
