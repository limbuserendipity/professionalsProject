package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.limbuserendipity.professionalsproject.data.factory.AppViewModelFactory
import com.limbuserendipity.professionalsproject.domain.usecase.AuthenticationUseCase
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInViewModel

@Composable
fun Navigation(owner: ViewModelStoreOwner) {
    var navState by remember {
        mutableStateOf(NavState.SIGNIN)
    }
    when (navState) {
        NavState.SIGNIN -> {

            val auth = AuthenticationUseCase()
            val viewModel = ViewModelProvider(
                owner = owner,
                factory = createFactory {
                    SignInViewModel()
                }
            ).get(SignInViewModel::class.java)

            SignInScreen(
                viewmodel = viewModel,
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

fun createFactory(
    onCreate : () -> ViewModel
) : ViewModelProvider.Factory{
    return object : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return onCreate() as T
        }
    }
}