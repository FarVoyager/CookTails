package com.example.cooktails.detailsFragment

import com.example.cooktails.model.Cocktail
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsPresenter(
    private val router: Router,
    private val cocktail: Cocktail
) : MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        showDetailsInfo()
    }

    private fun showDetailsInfo() {
        viewState.showName(cocktail.name)
        viewState.showImage(cocktail.imageUrl)
        viewState.showCategory(cocktail.category)
        viewState.showAlcoholic(cocktail.alcoholic)
        viewState.showGlass(cocktail.glass)
        viewState.showRecipe(cocktail.recipe)
        viewState.showIngredients(getIngredientsOfCocktail(cocktail))
        viewState.showMeasures(getMeasuresOfCocktail(cocktail))
    }

    fun getIngredientsOfCocktail(cocktail: Cocktail): List<String> {
        val listOfIngredients = mutableListOf<String>()

        fun addIngredientToList(ingredient: String?) {
            if (ingredient != null && ingredient != "") {
                listOfIngredients.add(ingredient)
            }
        }
        addIngredientToList(cocktail.strIngredient1)
        addIngredientToList(cocktail.strIngredient2)
        addIngredientToList(cocktail.strIngredient3)
        addIngredientToList(cocktail.strIngredient4)
        addIngredientToList(cocktail.strIngredient5)
        addIngredientToList(cocktail.strIngredient6)
        addIngredientToList(cocktail.strIngredient7)
        addIngredientToList(cocktail.strIngredient8)
        addIngredientToList(cocktail.strIngredient9)
        addIngredientToList(cocktail.strIngredient10)
        addIngredientToList(cocktail.strIngredient11)
        addIngredientToList(cocktail.strIngredient12)
        addIngredientToList(cocktail.strIngredient13)
        addIngredientToList(cocktail.strIngredient14)
        addIngredientToList(cocktail.strIngredient15)
        return listOfIngredients
    }

    private fun getMeasuresOfCocktail(cocktail: Cocktail): List<String> {
        val listOfMeasures = mutableListOf<String>()

        fun addMeasureToList(measure: String?) {
            if (measure != null && measure != "") { listOfMeasures.add(measure) }
        }
        addMeasureToList(cocktail.strMeasure1)
        addMeasureToList(cocktail.strMeasure2)
        addMeasureToList(cocktail.strMeasure3)
        addMeasureToList(cocktail.strMeasure4)
        addMeasureToList(cocktail.strMeasure5)
        addMeasureToList(cocktail.strMeasure6)
        addMeasureToList(cocktail.strMeasure7)
        addMeasureToList(cocktail.strMeasure8)
        addMeasureToList(cocktail.strMeasure9)
        addMeasureToList(cocktail.strMeasure10)
        addMeasureToList(cocktail.strMeasure11)
        addMeasureToList(cocktail.strMeasure12)
        addMeasureToList(cocktail.strMeasure13)
        addMeasureToList(cocktail.strMeasure14)
        addMeasureToList(cocktail.strMeasure15)
        return listOfMeasures
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}