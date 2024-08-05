package com.example.cities.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cities.presentation.splashScreen.nav.splashScreen
import com.example.cities.presentation.splashScreen.nav.splashScreenRoute

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = splashScreenRoute) {
        splashScreen { }
    }
}