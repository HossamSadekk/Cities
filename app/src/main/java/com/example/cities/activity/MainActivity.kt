package com.example.cities.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cities.core.navigation.MainNavigation
import com.example.cities.core.theme.CitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CitiesTheme {
                MainNavigation()
            }
        }
    }
}