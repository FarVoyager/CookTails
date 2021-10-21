package com.example.cooktails.model.room

import androidx.room.*

@Dao
interface CocktailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cocktail: RoomCocktail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg cocktails: RoomCocktail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cocktails: List<RoomCocktail>)

    @Update
    fun update(cocktail: RoomCocktail)

    @Update
    fun update(vararg cocktails: RoomCocktail)

    @Update
    fun update(cocktails: List<RoomCocktail>)

    @Delete
    fun delete(cocktail: RoomCocktail)

    @Delete
    fun delete(vararg cocktails: RoomCocktail)

    @Delete
    fun delete(cocktails: List<RoomCocktail>)

    @Query("SELECT * FROM RoomCocktail")
    fun getAll(): List<RoomCocktail>

    @Query("SELECT * FROM RoomCocktail WHERE name = :name")
    fun findByName(name: String): RoomCocktail?

    @Query("DELETE FROM RoomCocktail")
    fun deleteAll()
}