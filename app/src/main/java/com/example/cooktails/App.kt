package com.example.cooktails

import com.example.cooktails.di.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.plugins.RxJavaPlugins

//I/System.out: onError: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
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
            }
            .build()

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {  }
        instance = this
    }

}