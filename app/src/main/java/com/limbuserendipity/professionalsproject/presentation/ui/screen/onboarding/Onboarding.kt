package com.limbuserendipity.professionalsproject.presentation.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppButton

@Composable
fun OnboardingScreen(){

    var board by remember {
        mutableStateOf(BoardingState.BOARD1)
    }
    val brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF48B2E7),
            Color(0xFF44A9DC),
            Color(0xFF2B6B8B),
        )
    )
    Box(
        modifier = Modifier
            .background(brush = brush)
    ) {

        AnimatedVisibility(
            visible = board == BoardingState.BOARD1
        ) {

            Onboard1(
                onNextBoard = {
                    board = BoardingState.BOARD2
                }
            )

        }

        AnimatedVisibility(
            visible = board == BoardingState.BOARD2
        ) {

            Onboard1(
                onNextBoard = {
                    board = BoardingState.BOARD3
                }
            )

        }

    }


}

@Composable
fun Onboard1(
    onNextBoard : () -> Unit
){

    Column() {

        Text(
            text = stringResource(R.string.wellcome),
            style = MaterialTheme.typography.headlineMedium
        )

        Image(
            painter = painterResource(R.drawable.image3),
            contentDescription = stringResource(R.string.wellcome)
        )

        AppButton(
            text = stringResource(R.string.start),
            onClick = {

            },
            color = MaterialTheme.colorScheme.surface
        )

    }

}

@Composable
fun Onboard2(){

}

@Composable
fun Onboard3(){

}

enum class BoardingState{
    BOARD1, BOARD2, BOARD3
}