package com.example.cities.presentation.homeScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cities.R.font
import com.example.cities.core.designSystem.components.LoaderWithOffset
import com.example.cities.core.designSystem.components.MainAppBar
import com.example.cities.core.designSystem.components.state.SearchWidgetState
import com.example.cities.data.model.City
import com.example.cities.presentation.homeScreen.components.CityItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = koinViewModel()) {
    var searchWidgetState by remember { mutableStateOf(SearchWidgetState.CLOSED) }
    var searchTextState by remember { mutableStateOf("") }
    val cities by viewModel.cities.collectAsState()
    val filterText by viewModel.filterText.collectAsState()
    val loadingState by viewModel.isLoading.collectAsState()
    var isLoading by remember { mutableStateOf(true) }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = filterText,
                onTextChange = {
                    viewModel.onFilterTextChanged(it)
                },
                onCloseClicked = {
                    searchWidgetState = SearchWidgetState.CLOSED
                },
                onSearchTriggered = {
                    searchWidgetState = SearchWidgetState.OPENED
                }
            )
        }
    ) {
        LoaderWithOffset(
            isLoading = isLoading,
            offset = 50
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
            ) {
                LazyColumn {
                    items(cities) { city ->
                        CityItem(city) { selectedCity ->
                            onCityItemClick(selectedCity, context)
                        }
                    }
                }
            }
            if (cities.isNotEmpty()) {
                isLoading = false
            }
        }
    }
}

fun onCityItemClick(city: City, context: Context) {
    val gmmIntentUri =
        Uri.parse("geo:${city.coord.lat},${city.coord.lon}?q=${city.name},${city.country}")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")
    if (mapIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(mapIntent)
    }
}
