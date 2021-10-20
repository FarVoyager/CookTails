package com.example.cooktails.di.modules

import android.content.Context
import androidx.room.Room
import com.example.cooktails.model.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun bindDatabase(context: Context): Database = Room.databaseBuilder(context, Database::class.java, "database")
        .build()

}