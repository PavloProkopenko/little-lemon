package com.prokopenko.littlelemon.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.prokopenko.littlelemon.data.AppRepository
import com.prokopenko.littlelemon.data.model.MenuItemLocal
import com.prokopenko.littlelemon.data.model.util.Result
import com.prokopenko.littlelemon.data.model.util.asResult
import com.prokopenko.littlelemon.data.network.LittleLemonApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class HomeVM(application: Application) : AndroidViewModel(application = application) {
    private val appRepository = AppRepository(
        application.applicationContext,
        LittleLemonApi()
    )
    private val _menuData = MutableStateFlow<Result<List<MenuItemLocal>>>(Result.Loading)
    val menuData: StateFlow<Result<List<MenuItemLocal>>> = _menuData

    init {
        fetchData()
    }

    fun fetchData() {
        appRepository.getMenuData()
            .asResult()
            .onEach { _menuData.value = it }
            .launchIn(viewModelScope)
    }
}