package com.example.cooktails.mainActivity

import com.example.cooktails.di.DaggerAppComponent
import com.example.cooktails.model.room.Database
import com.example.cooktails.view.glide.GlideImageLoader
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withScheduler(AndroidSchedulers.mainThread())
                withGlideImageLoader(GlideImageLoader())
            }
            .build()
}