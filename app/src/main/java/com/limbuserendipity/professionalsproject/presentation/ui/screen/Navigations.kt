package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInViewModel

@Composable
fun Navigation(provider: ViewModelProvider) {
    var navState by remember {
        mutableStateOf(NavState.SIGNIN)
    }
    when (navState) {
        NavState.SIGNIN -> {
            SignInScreen(
                viewmodel = provider.get(SignInViewModel::class.java),
                toHomeScreen = {
                    navState = NavState.HOME
                }
            )
        }
        NavState.HOME -> {

        }
    }
}

enum class NavState {
    SIGNIN, HOME
}