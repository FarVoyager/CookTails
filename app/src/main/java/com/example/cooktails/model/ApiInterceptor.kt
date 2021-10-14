package com.example.cooktails.model

import okhttp3.Interceptor
import okhttp3.Response

object ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(
            chain.request()
                .newBuilder()
                .header("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
                .header("x-rapidapi-key", "cfc6954556mshf81f983a9852c45p12b985jsne3df15112912")
                .build()
        )
    }
}