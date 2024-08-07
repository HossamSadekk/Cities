package com.example.cities.data.datasource.imp

import android.content.Context
import android.util.Log
import com.example.cities.data.datasource.CityDataSource
import com.example.cities.data.model.City
import com.example.cities.data.model.Coord
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class CityDataSourceImpl(
    private val context: Context,
) : CityDataSource {
    override suspend fun getCities(): List<City> {
        return withContext(Dispatchers.IO) {
            val cities = mutableListOf<City>()
            val inputStream: InputStream = context.assets.open("cities.json")
            val reader = JsonReader(InputStreamReader(inputStream))

            try {
                reader.beginArray()
                while (reader.hasNext()) {
                    val city = parseCity(reader)
                    cities.add(city)
                }
                reader.endArray()
            } catch (e: IOException) {
                Log.d("CityDataSourceImpl", e.message.orEmpty())
            } finally {
                reader.close()
            }

            cities
        }
    }

    private fun parseCity(reader: JsonReader): City {
        var country = ""
        var name = ""
        var id = 0
        var coord: Coord? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "country" -> country = reader.nextString()
                "name" -> name = reader.nextString()
                "_id" -> id = reader.nextInt()
                "coord" -> coord = parseCoord(reader)
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return City(country, name, id, coord ?: Coord(0.0, 0.0))
    }

    private fun parseCoord(reader: JsonReader): Coord {
        var lon = 0.0
        var lat = 0.0

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "lon" -> lon = reader.nextDouble()
                "lat" -> lat = reader.nextDouble()
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return Coord(lon, lat)
    }
}