package com.limbuserendipity.professionalsproject.presentation.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(

){
    Scaffold(
        bottomBar = {
            AppBottomBar()
        }
    ) { paddingValues ->
        HomeContent(paddingValues)
    }
}
@Composable
fun HomeContent(paddingValues: PaddingValues) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        Text(
            text = "sfdflsdof[ijksrf",
            fontSize = 123.sp
        )
    }

}