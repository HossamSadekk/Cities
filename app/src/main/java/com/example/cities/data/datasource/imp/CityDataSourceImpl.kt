package com.example.cities.data.datasource.imp

import android.content.Context
import com.example.cities.data.datasource.CityDataSource
import com.example.cities.data.model.City
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class CityDataSourceImpl(
    private val context: Context,
    private val moshi: Moshi,
) : CityDataSource {

    override suspend fun getCities(): List<City> {
        return withContext(Dispatchers.IO) {
            try {
                val json = context.assets.open("cities.json").bufferedReader().use { it.readText() }
                val type = Types.newParameterizedType(List::class.java, City::class.java)
                val adapter = moshi.adapter<List<City>>(type)
                adapter.fromJson(json) ?: emptyList()
            } catch (e: IOException) {
                emptyList()
            }
        }
    }
}