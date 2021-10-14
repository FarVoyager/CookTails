package com.example.cooktails.view.rv

interface MainItemView: IMainItemView {
    fun setName(text: String)
    fun setImage(url: String)
    fun setCategory(text: String)
    fun setAlcoholic(text: String)
    fun setRecipe(text: String)
}