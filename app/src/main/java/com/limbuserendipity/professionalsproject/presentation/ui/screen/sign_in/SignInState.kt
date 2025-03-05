package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in


data class SignInState(
    var email : String = "",
    var password : String = "",
    var isEmailValid : Boolean? = null,
    var isPasswordVisible : Boolean = false,
    var isDialogVisible : Boolean = false
)