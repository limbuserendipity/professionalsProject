package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppButton

@Composable
fun SignInScreen(){

    Surface(

    ) {
        SignInContent()
    }

}

@Composable
fun SignInContent(){

    var email by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {

        TextField(
            value = email,
            onValueChange = { value ->
                email = value
            }
        )
        TextField(
            value = password,
            onValueChange = { value ->
                password = value
            }
        )

    }

}