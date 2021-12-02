package com.example.cooktails.di

import android.content.Context
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.example.cooktails.mainFragment.SearchQueryValidator
import com.example.cooktails.screens.AndroidScreens
import com.example.cooktails.view.glide.GlideImageLoader
import com.example.cooktails.view.glide.IImageLoader
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpAppCompatFragment
import javax.inject.Inject

abstract class AbsFragment(@LayoutRes contentLayoutId: Int): MvpAppCompatFragment(contentLayoutId), HasAndroidInjector {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var androidScreens: AndroidScreens
    @Inject
    lateinit var scheduler: Scheduler
    @Inject
    lateinit var searchQueryValidator: SearchQueryValidator

    @Inject
    lateinit var glideImageLoader: IImageLoader<ImageView>

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}