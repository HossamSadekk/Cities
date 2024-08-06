package com.example.cities.data.di

import com.example.cities.data.datasource.CityDataSource
import com.example.cities.data.datasource.imp.CityDataSourceImpl
import com.example.cities.data.repository.CityRepositoryImpl
import com.example.cities.domain.repository.CityRepository
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { Moshi.Builder().build() }
    single<CityDataSource> { CityDataSourceImpl(androidContext(), get()) }
    single<CityRepository> { CityRepositoryImpl(get()) }

}