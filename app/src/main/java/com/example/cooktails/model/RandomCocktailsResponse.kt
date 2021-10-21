package com.example.cooktails.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RandomCocktailsResponse (
    @Expose @SerializedName("drinks") val response: List<Cocktail> = mutableListOf()
    ) : Parcelable