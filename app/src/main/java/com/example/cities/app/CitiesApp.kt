package com.example.cities.app

import android.app.Application
import com.example.cities.di.initKoin
import org.koin.android.ext.koin.androidContext

class CitiesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CitiesApp)
        }
    }
}