package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
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

    if(state.value.isEmailValid == true){
        toHomeScreen()
    }

    Surface(
    ) {
        SignInContent(
            isPasswordVisible = state.value.isPasswordVisible,
            isDialogVisible = state.value.isDialogVisible,
            onDialogDismiss = viewmodel::showDialog,
            onUpdatePasswordVisible = viewmodel::showPassword,
            onAuthClick = viewmodel::authentication
        )
    }
}

@Composable
fun SignInContent(
    isPasswordVisible: Boolean,
    isDialogVisible : Boolean,
    onDialogDismiss : () -> Unit,
    onUpdatePasswordVisible: () -> Unit,
    onAuthClick: (String, String) -> Unit
) {

    var email: String by remember {
        mutableStateOf("")
    }
    var password: String by remember {
        mutableStateOf("")
    }

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
            onValueChange = {
                email = it
            },
            singleLine = true,
        )
        TextField(
            value = password,
            onValueChange = {
                password = password
            },
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
            onClick = {
                onAuthClick(email, password)
            }
        )

        if(isDialogVisible){
            Dialog(
                onDismissRequest = onDialogDismiss,
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(196.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "Ваш email или password не true"
                    )
                }
            }
        }

    }
}
