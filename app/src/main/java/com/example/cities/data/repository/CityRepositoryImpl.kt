package com.example.cities.data.repository

import com.example.cities.data.datasource.CityDataSource
import com.example.cities.data.model.City
import com.example.cities.domain.repository.CityRepository

class CityRepositoryImpl(
    private val cityDataSource: CityDataSource,
) : CityRepository {
    override suspend fun getCities(): List<City> = cityDataSource.getCities()
}