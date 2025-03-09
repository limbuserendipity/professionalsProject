package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.limbuserendipity.professionalsproject.data.factory.RepositoryFactory
import com.limbuserendipity.professionalsproject.domain.usecase.AuthenticationUseCase
import com.limbuserendipity.professionalsproject.presentation.ui.screen.home.HomeScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.onboarding.OnboardingScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInViewModel
import com.limbuserendipity.professionalsproject.presentation.ui.screen.splash_screen.SplashContent
import com.limbuserendipity.professionalsproject.presentation.ui.screen.splash_screen.SplashScreen

@Composable
fun Navigation(owner: ViewModelStoreOwner) {
    var navState by remember {
        mutableStateOf(NavState.SIGN_IN)
    }

    val authUseCase = AuthenticationUseCase(RepositoryFactory.getAuthenticationRepositoryImpl())
    val viewModel = ViewModelProvider(
        owner = owner,
        factory = createFactory {
            SignInViewModel(authenticationUseCase = authUseCase)
        }
    ).get(SignInViewModel::class.java)

    when(navState){
        NavState.SIGN_IN -> {
//            SignInScreen(
//                viewmodel = viewModel,
//                toHomeScreen = {
//                    navState = NavState.SPLASH
//                }
//            )

            HomeScreen()
        }
        NavState.SPLASH -> {
            SplashScreen(
                toOnboarding = {
                    navState = NavState.ONBOARDING
                }
            )
        }
        NavState.ONBOARDING -> {
            OnboardingScreen(
                toHomeScreen = {
                    navState = NavState.HOME
                }
            )
        }
        NavState.HOME -> {
            HomeScreen()
        }
    }
}

enum class NavState {
    SIGN_IN, HOME, SPLASH, ONBOARDING
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