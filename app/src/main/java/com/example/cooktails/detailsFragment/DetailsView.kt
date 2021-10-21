package com.example.cooktails.detailsFragment

import com.example.cooktails.model.Cocktail
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView: MvpView {
    fun showName(text: String?)
    fun showImage(url: String?)
    fun showCategory(text: String?)
    fun showAlcoholic(text: String?)
    fun showGlass(text: String?)
    fun showRecipe(text: String?)
    fun showIngredients(ingredients: List<String>)
    fun showMeasures(measures: List<String>)
}