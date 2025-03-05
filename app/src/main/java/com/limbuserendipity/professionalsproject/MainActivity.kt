package com.limbuserendipity.professionalsproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.limbuserendipity.professionalsproject.presentation.ui.screen.Navigation
import com.limbuserendipity.professionalsproject.presentation.ui.theme.ProfessionalsProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfessionalsProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> innerPadding
                    val provider = ViewModelProvider(this)
                    Navigation(provider = provider)
                }
            }
        }
    }
}