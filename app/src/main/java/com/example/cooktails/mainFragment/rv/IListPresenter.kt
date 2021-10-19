package com.example.cooktails.mainFragment.rv

interface IListPresenter<V: IMainItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

    interface IMainListPresenter: IListPresenter<MainItemView>
}