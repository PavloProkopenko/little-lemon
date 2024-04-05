package com.prokopenko.littlelemon.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.prokopenko.littlelemon.data.PreferenceRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ProfileVM (application: Application) : AndroidViewModel(application = application) {
    val user = PreferenceRepository(application.applicationContext).getUser()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            null
        )
}