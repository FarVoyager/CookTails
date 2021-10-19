package com.example.cooktails.mainFragment.rv

interface MainItemView: IMainItemView {
    fun setName(text: String)
    fun setImage(url: String)
    fun setCategory(text: String)
    fun setAlcoholic(text: String)
    fun setGlass(text: String)
}