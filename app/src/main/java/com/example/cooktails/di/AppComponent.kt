package com.example.cooktails.di

import android.content.Context
import android.widget.ImageView
import com.example.cooktails.mainActivity.App
import com.example.cooktails.di.modules.ApiModule
import com.example.cooktails.di.modules.CocktailsModule
import com.example.cooktails.di.modules.ScreensModule
import com.example.cooktails.di.modules.StorageModule
import com.example.cooktails.view.glide.GlideImageLoader
import com.example.cooktails.view.glide.IImageLoader
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Singleton
@Component(modules = [ScreensModule::class, AndroidInjectionModule::class, ApiModule::class, CocktailsModule::class, StorageModule::class])
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

        @BindsInstance
        fun withGlideImageLoader(glideImageLoader: IImageLoader<ImageView>): Builder

        fun build(): AppComponent
    }
}