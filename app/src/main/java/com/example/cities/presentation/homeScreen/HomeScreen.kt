package com.example.cities.presentation.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cities.core.designSystem.components.MainAppBar
import com.example.cities.core.designSystem.components.state.SearchWidgetState

@Composable
fun HomeScreen() {
    var searchWidgetState by remember { mutableStateOf(SearchWidgetState.CLOSED) }
    var searchTextState by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    searchTextState = it
                },
                onCloseClicked = {
                    searchWidgetState = SearchWidgetState.CLOSED
                    searchTextState = ""
                },
                onSearchTriggered = {
                    searchWidgetState = SearchWidgetState.OPENED
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Example content
            Text("Hello World!")
        }
    }
}