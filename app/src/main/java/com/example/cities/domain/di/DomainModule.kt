package com.example.cities.domain.di

import com.example.cities.domain.usecase.SearchCitiesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { SearchCitiesUseCase(get()) }
}