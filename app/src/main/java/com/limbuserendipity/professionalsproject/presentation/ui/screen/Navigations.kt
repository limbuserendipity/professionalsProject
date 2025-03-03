package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.runtime.Composable

@Composable
fun Navigation(){
    val navState = NavState.SIGIN
    when(navState){
        NavState.SIGIN -> {

        }
    }
}

enum class NavState{
    SIGIN
}