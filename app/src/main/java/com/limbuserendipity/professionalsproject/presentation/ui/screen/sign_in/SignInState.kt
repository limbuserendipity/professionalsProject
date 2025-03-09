package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in


data class SignInState(
    var isEmailValid : Boolean? = null,
    var isPasswordVisible : Boolean = false,
    var isDialogVisible : Boolean = false
)