package com.example.cooktails.model.room

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.IDataSource
import com.example.cooktails.model.RandomCocktailsResponse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ResponseConverter @Inject constructor() : IResponseConverter {

    override fun convertToSingleList(receivedObject: Single<RandomCocktailsResponse>): Single<List<Cocktail>> {
        return receivedObject.flatMap {
            Single.just(it.response)
        }.subscribeOn(Schedulers.io())
    }
}
