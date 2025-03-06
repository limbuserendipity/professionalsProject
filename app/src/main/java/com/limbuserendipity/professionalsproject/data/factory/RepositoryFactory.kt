package com.limbuserendipity.professionalsproject.data.factory

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient

object RepositoryFactory {

    fun getSupaBaseRepository(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://bqodoawcvcfaptpcyljy.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJxb2RvYXdjdmNmYXB0cGN5bGp5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDEyNzI5NTgsImV4cCI6MjA1Njg0ODk1OH0.-6k1Ch6gc1B5ww1SdX6GadhTrNFq-M5_ZLjHmbePhVM"
        ) {
            install(Auth)
        }
    }

}