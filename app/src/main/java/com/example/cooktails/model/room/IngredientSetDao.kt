package com.example.cooktails.model.room

import androidx.room.*

@Dao
interface IngredientSetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ingredientSet: RoomIngredientSet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg ingredientSets: RoomIngredientSet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ingredientSets: List<RoomIngredientSet>)

    @Update
    fun update(ingredientSet: RoomIngredientSet)

    @Update
    fun update(vararg ingredientSets: RoomIngredientSet)

    @Update
    fun update(ingredientSets: List<RoomIngredientSet>)

    @Delete
    fun delete(ingredientSet: RoomIngredientSet)

    @Delete
    fun delete(vararg ingredientSets: RoomIngredientSet)

    @Delete
    fun delete(ingredientSets: List<RoomIngredientSet>)

    @Query("SELECT * FROM RoomIngredientSet")
    fun getAll(): List<RoomIngredientSet>

    @Query("SELECT * FROM RoomIngredientSet WHERE cocktailId = :cocktailId")
    fun findForCocktail(cocktailId: String): RoomIngredientSet?
}