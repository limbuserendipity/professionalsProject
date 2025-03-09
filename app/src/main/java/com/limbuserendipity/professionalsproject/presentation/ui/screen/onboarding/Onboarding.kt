package com.limbuserendipity.professionalsproject.presentation.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppButton

@Composable
fun OnboardingScreen(
    toHomeScreen: () -> Unit
){

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
            .fillMaxSize()
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

            Onboard2(
                onNextBoard = {
                    board = BoardingState.BOARD3
                }
            )

        }

        AnimatedVisibility(
            visible = board == BoardingState.BOARD3
        ) {

            Onboard3(
                onNextBoard = {
                    toHomeScreen()
                }
            )

        }

    }


}

@Composable
fun Onboard1(
    onNextBoard : () -> Unit
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(
            text = stringResource(R.string.wellcome),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.size(102.dp))

        Image(
            painter = painterResource(R.drawable.image_1),
            contentDescription = stringResource(R.string.wellcome),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(302.dp)
        )

        Spacer(modifier = Modifier.size(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(43.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.size(162.dp))

        Box(modifier = Modifier.padding(horizontal = 20.dp)){
            AppButton(
                text = stringResource(R.string.start),
                onClick = {
                    onNextBoard()
                },
                color = MaterialTheme.colorScheme.surface
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
    }

}

@Composable
fun Onboard2(
    onNextBoard : () -> Unit
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(70.dp))

        Spacer(modifier = Modifier.size(102.dp))

        Image(
            painter = painterResource(R.drawable.image_2),
            contentDescription = stringResource(R.string.wellcome),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(302.dp)
        )

        Text(
            text = stringResource(R.string.journey),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = stringResource(R.string.smart),
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.size(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(43.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.size(162.dp))

        Box(modifier = Modifier.padding(horizontal = 20.dp)){
            AppButton(
                text = stringResource(R.string.next),
                onClick = {
                    onNextBoard()
                },
                color = MaterialTheme.colorScheme.surface
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
    }
}

@Composable
fun Onboard3(
    onNextBoard : () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(70.dp))

        Spacer(modifier = Modifier.size(102.dp))

        Image(
            painter = painterResource(R.drawable.image_2),
            contentDescription = stringResource(R.string.wellcome),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(302.dp)
        )

        Text(
            text = stringResource(R.string.journey),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = stringResource(R.string.smart),
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.size(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(43.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .size(28.dp, 5.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.size(162.dp))

        Box(modifier = Modifier.padding(horizontal = 20.dp)){
            AppButton(
                text = stringResource(R.string.next),
                onClick = {
                    onNextBoard()
                },
                color = MaterialTheme.colorScheme.surface
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
    }
}

enum class BoardingState{
    BOARD1, BOARD2, BOARD3
}