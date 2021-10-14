package com.example.cooktails.view.glide

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}