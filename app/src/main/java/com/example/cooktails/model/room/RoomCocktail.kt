package com.example.cooktails.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomCocktail (
    @PrimaryKey var id: String,
    var name: String,
    var imageUrl: String,
    var category: String,
    var alcoholic:  String,
    var glass: String,
    var recipe: String
        )