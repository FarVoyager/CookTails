package com.example.cooktails.mainFragment

import javax.inject.Inject

class SearchQueryValidator @Inject constructor() {

    fun isValidQuery(query: String?): Boolean {
        if (query != null) {
            return query.isNotEmpty()
        } else return false
    }

}