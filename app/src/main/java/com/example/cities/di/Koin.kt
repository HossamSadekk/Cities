package com.example.cities.di

import com.example.cities.data.di.dataModule
import com.example.cities.domain.di.domainModule
import com.example.cities.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(dataModule, domainModule, presentationModule)
    }