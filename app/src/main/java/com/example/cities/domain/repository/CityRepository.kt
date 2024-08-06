package com.example.cities.domain.repository

import com.example.cities.data.model.City

interface CityRepository {
    suspend fun getCities(): List<City>
}