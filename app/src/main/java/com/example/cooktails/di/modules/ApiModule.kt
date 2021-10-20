package com.example.cooktails.di.modules

import com.example.cooktails.model.ApiInterceptor
import com.example.cooktails.model.IDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class ApiModule {

    @Reusable
    @Provides
    fun provideCocktailStorage(): IDataSource =
        Retrofit.Builder()
            .baseUrl("https://the-cocktail-db.p.rapidapi.com")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create())
            )
            .client(OkHttpClient.Builder()
                .addInterceptor(ApiInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
            )
            .build()
            .create(IDataSource::class.java)

}