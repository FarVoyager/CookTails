package com.example.cooktails.mainFragment

import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.ICocktailsRepo
import com.example.cooktails.mainFragment.rv.IListPresenter
import com.example.cooktails.mainFragment.rv.MainItemView
import com.example.cooktails.screens.AndroidScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.lang.StringBuilder

class MainPresenter(
    private val router: Router,
    private val cocktailsRepo: ICocktailsRepo,
    private val uiScheduler: Scheduler,
    private val screens: AndroidScreens

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
    var isNonAlcoholicChecked = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        mainListPresenter.itemClickListener = { itemView ->
            router.navigateTo(screens.details(mainListPresenter.cocktailsList[itemView.pos]))
        }
    }

    private fun loadData() {
        val cocktailsRx =
            cocktailsRepo.getRandomCocktails()
        cocktailsRx
            .observeOn(uiScheduler)
            .doOnSubscribe { d -> compositeDisposable.addAll(d) }
            .subscribe({
                mainListPresenter.cocktailsList.clear()
                it.let { it1 -> mainListPresenter.cocktailsList.addAll(it1) }

                viewState.updateRvListUnitsCount("${mainListPresenter.cocktailsList.size} ea")
                viewState.updateList()
                println("onSuccess")
            }, {
                println("onError: ${it.message}")
            })
    }


    fun loadCocktailDatabase() {
        val cachedCocktailsRx = cocktailsRepo.getCachedCocktails()
        cachedCocktailsRx
            .observeOn(uiScheduler)
            .doOnSubscribe { d -> compositeDisposable.addAll(d) }
            .subscribe({
                mainListPresenter.cocktailsList.clear()
                mainListPresenter.cocktailsList.addAll(it)

                setRvVisibility()

                viewState.updateList()
                viewState.updateRvListHeader("All cocktails")
                viewState.updateRvListUnitsCount("${mainListPresenter.cocktailsList.size} ea")
            }, {
                println("onError: ${it.message}")
            })
    }

    fun loadRandomCocktails() {
        val cocktailsRx =
            cocktailsRepo.getRandomCocktails()
        cocktailsRx
            .observeOn(uiScheduler)
            .doOnSubscribe { d -> compositeDisposable.addAll(d) }
            .subscribe({
                mainListPresenter.cocktailsList.clear()
                it.let { it1 -> mainListPresenter.cocktailsList.addAll(it1) }

                setRvVisibility()
                viewState.updateList()
                viewState.updateRvListHeader("10 random cocktails")
                viewState.updateRvListUnitsCount("${mainListPresenter.cocktailsList.size} ea")
                println("onSuccess")
            }, {
                println("onError: ${it.message}")
            })
    }


    fun getSearchQuery(query: String): String {
        return query
    }

    fun loadBrowsed() {
        viewState.setSearchLayoutVisibility()
    }

    fun onSearchClicked(query: String) {
        val cachedCocktailsRx = cocktailsRepo.getCachedCocktailsByIngredient(query)
        cachedCocktailsRx
            .observeOn(uiScheduler)
            .doOnSubscribe { d -> compositeDisposable.addAll(d) }
            .subscribe({
                mainListPresenter.cocktailsList.clear()
                fillList(it)
                setRvVisibility()
                viewState.updateList()
                viewState.updateRvListHeader("Search results:")
                viewState.updateRvListUnitsCount("${mainListPresenter.cocktailsList.size} ea")
            }, {
                println("onError: ${it.message}")
            })
    }

    fun getNonAlcoholicCheck(isChecked: Boolean) {
        isNonAlcoholicChecked = isChecked

    }

    private fun setRvVisibility() {
        if (mainListPresenter.cocktailsList.size == 0) viewState.updateRvVisibility(true)
        else viewState.updateRvVisibility(false)
    }

    private fun fillList(list: List<Cocktail>) {
        viewState.isNonAlcoholicChecked()
        if (isNonAlcoholicChecked) {
            for (i in list.indices) {
                if ( list[i].alcoholic == "Non alcoholic") mainListPresenter.cocktailsList.add(list[i])
            }
        } else {
            mainListPresenter.cocktailsList.addAll(list)
        }

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