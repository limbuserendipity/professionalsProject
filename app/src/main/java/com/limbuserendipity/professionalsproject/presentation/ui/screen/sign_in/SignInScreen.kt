package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppButton
import com.limbuserendipity.professionalsproject.presentation.ui.theme.eyeClose
import com.limbuserendipity.professionalsproject.presentation.ui.theme.eyeOpen

@Composable
fun SignInScreen(
    viewmodel: SignInViewModel,
    toHomeScreen : () -> Unit
) {
    val state = viewmodel.state.collectAsState()

    Surface(
    ) {
        SignInContent(
            email = state.value.email,
            password = state.value.password,
            isPasswordVisible = state.value.isPasswordVisible,
            onUpdateEmail = viewmodel::updateEmail,
            onUpdatePassword = viewmodel::updatePassword,
            onUpdatePasswordVisible = viewmodel::showPassword,
            onAuthClick = viewmodel::authentication
        )
    }
}

@Composable
fun SignInContent(
    email: String,
    password: String,
    isPasswordVisible: Boolean,
    onUpdateEmail: (String) -> Unit,
    onUpdatePassword: (String) -> Unit,
    onUpdatePasswordVisible: () -> Unit,
    onAuthClick: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        val iconPath = if (isPasswordVisible) eyeClose else eyeOpen
        val description = if (isPasswordVisible) "Hide password" else "Show password"
        val transformation = if (isPasswordVisible)
            VisualTransformation.None
        else PasswordVisualTransformation()
        TextField(
            value = email,
            onValueChange = onUpdateEmail,
            singleLine = true,
        )
        TextField(
            value = password,
            onValueChange = onUpdatePassword,
            visualTransformation = transformation,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = onUpdatePasswordVisible) {
                    Icon(painter = painterResource(iconPath), description)
                }
            }
        )
        AppButton(
            text = stringResource(R.string.sign_In),
            onClick = onAuthClick
        )
    }
}
