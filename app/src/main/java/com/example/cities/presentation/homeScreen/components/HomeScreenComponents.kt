package com.example.cities.presentation.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cities.R.font
import com.example.cities.data.model.City

@Composable
fun CityItem(city: City, onCityClick: (City) -> Unit) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCityClick(city) },
        headlineContent = {
            Text(
                "${city.name}, ${city.country}", style = TextStyle(
                    fontFamily = FontFamily(Font(font.poppins_semibold)),
                    fontWeight = FontWeight.Medium
                ), fontSize = 20.sp
            )
        },
        supportingContent = {
            Text(
                "Lat: ${city.coord.lat}, Lon: ${city.coord.lon}", style = TextStyle(
                    fontFamily = FontFamily(Font(font.poppins_regular)),
                )
            )
        }
    )
}