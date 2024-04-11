package com.prokopenko.littlelemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prokopenko.littlelemon.data.AppRepository
import com.prokopenko.littlelemon.data.model.MenuItem
import com.prokopenko.littlelemon.data.model.util.Result
import com.prokopenko.littlelemon.data.model.util.asResult
import com.prokopenko.littlelemon.data.network.LittleLemonApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach


class HomeVM: ViewModel() {
    private val appRepository = AppRepository(LittleLemonApi())
    private val _menuData = MutableStateFlow<Result<List<MenuItem>>>(Result.Loading)
    val menuData: StateFlow<Result<List<MenuItem>>> = _menuData

    init {
        fetchData();
    }

    fun fetchData() {
        appRepository.getMenuData()
            .map { it.menu }
            .asResult()
            .onEach { _menuData.value = it }
            .launchIn(viewModelScope)
    }
}