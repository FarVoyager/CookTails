package com.example.cooktails.di.modules

import android.content.Context
import androidx.room.Room
import com.example.cooktails.model.room.Database
import com.example.cooktails.model.room.IResponseConverter
import com.example.cooktails.model.room.ResponseConverter
import com.example.cooktails.model.room.networkStatus.AndroidNetworkStatus
import com.example.cooktails.model.room.networkStatus.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun bindDatabase(context: Context): Database = Room.databaseBuilder(context, Database::class.java, "database")
        .build()

    @Provides
    fun bindNetworkStatus(context: Context): INetworkStatus = AndroidNetworkStatus(context)

    @Provides
    fun bindResponseConverter(): IResponseConverter = ResponseConverter()
}