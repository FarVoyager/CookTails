package com.example.cooktails.di

import android.content.Context
import com.example.cooktails.App
import com.example.cooktails.di.modules.CocktailsModule
import com.example.cooktails.di.modules.ScreensModule
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Singleton
@Component(modules = [ScreensModule::class, CocktailsModule::class, AndroidInjectionModule::class])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withScheduler(scheduler: Scheduler): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): AppComponent
    }
}