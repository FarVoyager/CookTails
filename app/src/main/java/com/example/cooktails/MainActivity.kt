package com.example.cooktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cooktails.di.AbsActivity

class MainActivity : AbsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}