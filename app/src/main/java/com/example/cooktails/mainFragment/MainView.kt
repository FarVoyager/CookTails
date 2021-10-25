package com.example.cooktails.mainFragment

import com.google.android.material.button.MaterialButton
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {
    fun init()
    fun updateList()
    fun updateRvListHeader(text: String)
    fun updateRvListUnitsCount(text: String)
    fun showToast(text: String)

    fun setSearchLayoutVisibility()
    fun isNonAlcoholicChecked()
    fun updateRvVisibility(isListEmpty: Boolean)
    fun setBtnColor(button: MaterialButton? ,backgroundColor: Int, strokeColor: Int, textColor: Int)

}