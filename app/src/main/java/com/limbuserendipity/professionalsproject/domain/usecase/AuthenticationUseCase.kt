package com.limbuserendipity.professionalsproject.domain.usecase

import com.limbuserendipity.professionalsproject.domain.repository.AuthenticationRepository

class AuthenticationUseCase(private val auth : AuthenticationRepository) {

    suspend fun invoke(email : String, password : String){
        auth.authentication(email, password)
    }

}