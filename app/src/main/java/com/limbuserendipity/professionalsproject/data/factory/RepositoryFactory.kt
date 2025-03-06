package com.limbuserendipity.professionalsproject.data.factory

import com.limbuserendipity.professionalsproject.data.repository.AuthenticationRepositoryImpl
import com.limbuserendipity.professionalsproject.domain.repository.AuthenticationRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient

object RepositoryFactory {

    fun getAuthenticationRepositoryImpl(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }

}