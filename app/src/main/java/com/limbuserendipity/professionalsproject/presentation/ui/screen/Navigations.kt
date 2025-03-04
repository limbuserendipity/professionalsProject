package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.runtime.Composable
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInContent

@Composable
fun Navigation(){
    val navState = NavState.SIGNIN
    when(navState){
        NavState.SIGNIN -> {
            SignInContent()
        }
    }
}

enum class NavState{
    SIGNIN
}