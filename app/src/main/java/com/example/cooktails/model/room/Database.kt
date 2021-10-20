package com.example.cooktails.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomCocktail::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract val cocktailDao: CocktailDao
}