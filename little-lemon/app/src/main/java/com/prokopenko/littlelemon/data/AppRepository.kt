package com.prokopenko.littlelemon.data

import com.prokopenko.littlelemon.data.network.LittleLemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepository(
    private val littleLemonApi: LittleLemonApi
) {
    fun getMenuData() = flow {
        emit(littleLemonApi.getMenuData())
    }.flowOn(Dispatchers.IO)
}