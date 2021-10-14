package com.example.cooktails.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    @Expose @SerializedName("idDrink") val id: String? = null,
    @Expose @SerializedName("strDrink") val name: String? = null,
    @Expose @SerializedName("strDrinkThumb") val imageUrl: String? = null,
    @Expose @SerializedName("strCategory") val category: String? = null,
    @Expose @SerializedName("strAlcoholic") val alcoholic: String? = null,
    @Expose @SerializedName("strInstructions") val recipe: String? = null,

    @Expose val strIngredient1: String? = null,
    @Expose val strIngredient2: String? = null,
    @Expose val strIngredient3: String? = null,
    @Expose val strIngredient4: String? = null,
    @Expose val strIngredient5: String? = null,
    @Expose val strIngredient6: String? = null,
    @Expose val strIngredient7: String? = null,
    @Expose val strIngredient8: String? = null,
    @Expose val strIngredient9: String? = null,
    @Expose val strIngredient10: String? = null,
    @Expose val strIngredient11: String? = null,
    @Expose val strIngredient12: String? = null,
    @Expose val strIngredient13: String? = null,
    @Expose val strIngredient14: String? = null,
    @Expose val strIngredient15: String? = null,

    @Expose val strMeasure1: String? = null,
    @Expose val strMeasure2: String? = null,
    @Expose val strMeasure3: String? = null,
    @Expose val strMeasure4: String? = null,
    @Expose val strMeasure5: String? = null,
    @Expose val strMeasure6: String? = null,
    @Expose val strMeasure7: String? = null,
    @Expose val strMeasure8: String? = null,
    @Expose val strMeasure9: String? = null,
    @Expose val strMeasure10: String? = null,
    @Expose val strMeasure11: String? = null,
    @Expose val strMeasure12: String? = null,
    @Expose val strMeasure13: String? = null,
    @Expose val strMeasure14: String? = null,
    @Expose val strMeasure15: String? = null,

    ): Parcelable
