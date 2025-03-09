package com.limbuserendipity.professionalsproject.presentation.ui.screen.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.limbuserendipity.professionalsproject.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    toOnboarding : () -> Unit
) {
    SplashContent()

    LaunchedEffect(
        Unit
    ) {
        delay(3000)
        toOnboarding()
    }

}

@Composable
fun SplashContent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(129.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                )
        ){
            Icon(
                painter = painterResource(R.drawable.bag_2),
                contentDescription = "Icon"
            )
        }
    }
}