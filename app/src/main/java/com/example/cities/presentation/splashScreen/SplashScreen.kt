package com.example.cities.presentation.splashScreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cities.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashEnd: () -> Unit) {
    val scaleAnimationDuration = 1000 // Duration of the scale up and down animation
    val initialDelay = 1000 // Initial delay before starting the animation
    val delayBeforeEnd = 2000 // Duration to keep the final state before calling onSplashEnd

    var startAnimation by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1.5f else 1f,
        animationSpec = tween(durationMillis = scaleAnimationDuration, easing = FastOutSlowInEasing), label = ""
    )

    LaunchedEffect(Unit) {
        delay(initialDelay.toLong())
        startAnimation = true
        // Delay before scaling down
        delay(scaleAnimationDuration.toLong())
        startAnimation = false // Start scaling down
        // Delay for the final size before calling onSplashEnd
        delay(delayBeforeEnd.toLong())
        onSplashEnd()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.cities_app),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 30.sp * scale, // Apply animated scale
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontWeight = FontWeight.Bold
            )
        )
    }
}