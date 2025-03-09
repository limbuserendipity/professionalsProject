package com.limbuserendipity.professionalsproject.presentation.ui.screen.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.limbuserendipity.professionalsproject.domain.usecase.AuthenticationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    authenticationUseCase: AuthenticationUseCase
) : ViewModel(){

    private val _state = MutableStateFlow(SignInState())
    val state get() = _state

    private fun updateState(newState : SignInState){
        viewModelScope.launch {
            _state.emit(newState)
        }
    }

    fun authentication(email : String, password: String){
        val isEmailValid = checkEmailValidity(email)
        val isEmptyString = checkEmptyString(email, password)

        if(isEmptyString || !isEmailValid){
            showDialog()
            return
        }else{
            updateState(newState = state.value.copy(isEmailValid = true))
        }
    }

    fun showPassword(){
        updateState(state.value.copy(isPasswordVisible = !state.value.isPasswordVisible))
    }

    fun showDialog(){
        updateState(state.value.copy(isDialogVisible = !state.value.isDialogVisible))
    }

    private fun checkEmailValidity(email : String): Boolean {
        var isValid = true
        val name = email.substringBefore('@')
        val domainName = email
            .substringAfter('@')
            .substringBefore('.')
        val highDomain = email.substringAfter('.')

        isValid = name.all {
            it.isLowerCase()
        }
        if(!isValid) return false

        isValid = domainName.all{
            it.isLowerCase()
        }

        if(!isValid) return false

        isValid = highDomain.all{
            it.isLetter()
        }

        if(!isValid) return false

        isValid = highDomain.length > 2

        return isValid
    }

    private fun checkEmptyString(email: String, password: String) : Boolean{
        return email.isEmpty() || password.isEmpty()
    }

}