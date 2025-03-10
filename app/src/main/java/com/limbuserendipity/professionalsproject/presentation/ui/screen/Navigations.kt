package com.limbuserendipity.professionalsproject.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.limbuserendipity.professionalsproject.data.factory.RepositoryFactory
import com.limbuserendipity.professionalsproject.domain.usecase.AuthenticationUseCase
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppBottomBar
import com.limbuserendipity.professionalsproject.presentation.ui.screen.home.HomeScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.onboarding.OnboardingScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInScreen
import com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in.SignInViewModel
import com.limbuserendipity.professionalsproject.presentation.ui.screen.splash_screen.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(owner: ViewModelStoreOwner) {
    var navState by remember {
        mutableStateOf(NavState.ONBOARDING)
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
            SignInScreen(
                viewmodel = viewModel,
                toHomeScreen = {
                    navState = NavState.SPLASH
                }
            )
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
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Главная")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                bottomBar = {
                    AppBottomBar(
                        toHomeScreen = {

                        },
                        toFavoriteScreen = {

                        },
                        toNotificationScreen = {

                        },
                        toProfileScreen = {

                        }
                    )
                }
            ) { paddingValues ->
                HomeScreen(paddingValues)
            }

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