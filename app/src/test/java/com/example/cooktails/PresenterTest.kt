package com.example.cooktails

import com.example.cooktails.detailsFragment.DetailsPresenter
import com.example.cooktails.mainFragment.MainPresenter
import com.example.cooktails.model.Cocktail
import com.example.cooktails.model.ICocktailsRepo
import com.example.cooktails.model.room.RetrofitCocktailsRepo
import com.example.cooktails.screens.AndroidScreens
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PresenterTest {

    private lateinit var mainPresenter: MainPresenter

    private lateinit var detailsPresenter: DetailsPresenter

    @Mock
    private lateinit var cocktailsRepo: RetrofitCocktailsRepo


    @Before
    fun setUpMocks() {
        MockitoAnnotations.openMocks(this)
        val router = Mockito.mock(Router::class.java)
        val uiScheduler = AndroidSchedulers.mainThread()
        val screens = Mockito.mock(AndroidScreens::class.java)
        val cocktail = Mockito.mock(Cocktail::class.java)

        detailsPresenter = DetailsPresenter(router, cocktail)

        mainPresenter = MainPresenter(router, cocktailsRepo, uiScheduler, screens)
    }

    @Test
    fun searchQueryRequest_Test() {
        mainPresenter.onSearchClicked("gin")
        verify(cocktailsRepo, times(1)).getCachedCocktailsByIngredient("gin")
    }

    @Test
    fun setRvVisibility_Test() {
        val list = Mockito.mock(List::class.java) as List<Cocktail>
        mainPresenter.setRvVisibility(list)
        Mockito.`when`(list.isEmpty()).thenReturn(false)
        assertFalse(mainPresenter.setRvVisibility(list))
    }


}