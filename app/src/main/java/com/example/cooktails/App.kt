package com.example.cooktails

import android.app.Application
import com.example.cooktails.di.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent.builder()
            .withScheduler(AndroidSchedulers.mainThread())
            .withContext(applicationContext).apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}