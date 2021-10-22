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

    @Query(FIND_BY_INGREDIENT_QUERY)
    fun findByIngredient(ingredient: String): List<RoomCocktail>

    @Query("DELETE FROM RoomCocktail")
    fun deleteAll()
}

const val FIND_BY_INGREDIENT_QUERY = "SELECT * FROM RoomCocktail WHERE name LIKE '%' || :ingredient || '%' COLLATE NOCASE  OR  strIngredient1 = :ingredient COLLATE NOCASE  OR strIngredient2 = :ingredient COLLATE NOCASE OR strIngredient3 = :ingredient COLLATE NOCASE OR strIngredient4 = :ingredient COLLATE NOCASE OR strIngredient5 = :ingredient COLLATE NOCASE OR strIngredient6 = :ingredient COLLATE NOCASE OR strIngredient7 = :ingredient COLLATE NOCASE OR strIngredient8 = :ingredient COLLATE NOCASE OR strIngredient9 = :ingredient COLLATE NOCASE OR strIngredient10 = :ingredient COLLATE NOCASE OR strIngredient11 = :ingredient COLLATE NOCASE OR strIngredient12 = :ingredient COLLATE NOCASE OR strIngredient13 = :ingredient COLLATE NOCASE OR strIngredient14 = :ingredient COLLATE NOCASE OR strIngredient15 = :ingredient COLLATE NOCASE"