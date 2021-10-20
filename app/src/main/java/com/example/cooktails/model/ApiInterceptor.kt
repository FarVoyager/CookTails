package com.example.cooktails.model

import com.example.cooktails.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

object ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(
            chain.request()
                .newBuilder()
                .header("x-rapidapi-host", BuildConfig.API_HOST)
                .header("x-rapidapi-key", BuildConfig.API_KEY)
                .build()
        )
    }
}