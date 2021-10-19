package com.example.cooktails.mainFragment

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.ICocktailsRepo
import com.example.cooktails.view.rv.IListPresenter
import com.example.cooktails.view.rv.MainItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
    private val cocktailsRepo: ICocktailsRepo,
    private val uiScheduler: Scheduler

): MvpPresenter<MainView>() {

    private var compositeDisposable = CompositeDisposable()

    class MainListPresenter: IListPresenter.IMainListPresenter {

        val cocktailsList = mutableListOf<Cocktail>()
        override var itemClickListener: ((MainItemView) -> Unit)? = null

        override fun bindView(view: MainItemView) {
            val cocktail = cocktailsList[view.pos]
            cocktail.name?.let { view.setName(it) }
            cocktail.imageUrl?.let { view.setImage(it) }
            cocktail.category?.let { view.setCategory(it) }
            cocktail.alcoholic?.let { view.setAlcoholic(it) }
            cocktail.glass?.let { view.setGlass(it) }
        }

        override fun getCount(): Int {
            return cocktailsList.size
        }
    }

    val mainListPresenter = MainListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        //clickListener
    }

    private fun loadData() {
        val cocktailsRx =
            cocktailsRepo.getRandomCocktails()
        cocktailsRx
            .observeOn(uiScheduler)
            .doOnSubscribe { d -> compositeDisposable.addAll(d) }
            .subscribe({
                mainListPresenter.cocktailsList.clear()
                it.response?.let { it1 -> mainListPresenter.cocktailsList.addAll(it1) }
                println(mainListPresenter.cocktailsList.size.toString() + " BEB size")
                viewState.updateList()
                println("onSuccess")
            }, {
                println("onError: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}