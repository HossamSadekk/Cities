package com.example.cities.data.datasource

import com.example.cities.data.model.City

interface CityDataSource {
    suspend fun getCities(): List<City>
}