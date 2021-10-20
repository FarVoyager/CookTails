package com.example.cooktails.model.room.networkStatus

import android.database.Observable
import io.reactivex.rxjava3.core.Single
import java.util.*

interface INetworkStatus {
    fun isOnline(): io.reactivex.rxjava3.core.Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}