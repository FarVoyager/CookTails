package com.example.cooktails

import com.example.cooktails.mainFragment.MainFragment
import com.example.cooktails.mainFragment.SearchQueryValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class SearchQueryTest {

    @Test
    fun searchQuery_EmptyField_ReturnsFalse() {
        assertFalse(SearchQueryValidator().isValidQuery(""))
    }

    @Test
    fun searchQuery_NullInserted_ReturnsFalse() {
        assertFalse(SearchQueryValidator().isValidQuery(null))
    }

    @Test
    fun searchQuery_CorrectQueryIngredient_ReturnsTrue() {
        assertTrue(SearchQueryValidator().isValidQuery("Orange"))
    }

    @Test
    fun searchQuery_CorrectQueryName_ReturnsTrue() {
        assertTrue(SearchQueryValidator().isValidQuery("Mojito"))
    }
}