package com.example.cities.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "country") val country: String,
    @Json(name = "name") val name: String,
    @Json(name = "_id") val id: Int,
    @Json(name = "coord") val coord: Coord,
)