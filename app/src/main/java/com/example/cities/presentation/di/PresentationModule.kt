package com.example.cities.presentation.di

import com.example.cities.presentation.homeScreen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::HomeScreenViewModel)
}