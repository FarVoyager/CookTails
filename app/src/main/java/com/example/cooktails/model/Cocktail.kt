package com.example.cooktails.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    @Expose val id: String? = null,
    @Expose val name: String? = null,
    @Expose val imageUrl: String? = null
): Parcelable
