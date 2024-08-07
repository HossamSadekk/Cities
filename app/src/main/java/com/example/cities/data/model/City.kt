package com.example.cities.data.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("country") val country: String,
    @SerializedName("name") val name: String,
    @SerializedName("_id") val id: Int,
    @SerializedName("coord") val coord: Coord,
)