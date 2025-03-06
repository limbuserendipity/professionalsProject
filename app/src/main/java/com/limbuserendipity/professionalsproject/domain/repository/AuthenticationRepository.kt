package com.limbuserendipity.professionalsproject.domain.repository

interface AuthenticationRepository {
    suspend fun authentication(email : String, password : String)
}