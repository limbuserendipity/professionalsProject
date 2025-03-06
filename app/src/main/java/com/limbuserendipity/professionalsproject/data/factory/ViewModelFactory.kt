package com.limbuserendipity.professionalsproject.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppViewModelFactory(
    val onCreate : () -> ViewModel
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return onCreate() as T
    }

}