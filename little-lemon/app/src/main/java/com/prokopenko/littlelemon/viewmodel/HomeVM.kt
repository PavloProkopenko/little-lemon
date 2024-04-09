package com.prokopenko.littlelemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prokopenko.littlelemon.data.AppRepository
import com.prokopenko.littlelemon.data.model.util.asResult
import com.prokopenko.littlelemon.data.network.LittleLemonApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class HomeVM: ViewModel() {
    private val appRepository = AppRepository(LittleLemonApi())
    val menuData = appRepository.getMenuData()
        .asResult()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            Result.Loading
        )
}