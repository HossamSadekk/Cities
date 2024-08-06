package com.example.cities.presentation.homeScreen.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cities.presentation.homeScreen.HomeScreen
import com.example.cities.presentation.splashScreen.nav.splashScreenRoute

const val homeScreenRoute = "homeScreenRoute"

fun NavGraphBuilder.homeScreen() {
    composable(route = homeScreenRoute) {
        HomeScreen()
    }
}

fun NavController.navigateToHomeScreen() =
    this.navigate(homeScreenRoute) { popUpTo(splashScreenRoute) { inclusive = true } }
