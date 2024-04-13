package com.prokopenko.littlelemon.data

import android.content.Context
import com.prokopenko.littlelemon.data.local.AppDatabase
import com.prokopenko.littlelemon.data.network.LittleLemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepository(
    context: Context,
    private val littleLemonApi: LittleLemonApi,
    private val appDatabase: AppDatabase = AppDatabase.getDatabase(context)
) {
    fun getMenuData() = flow {
        var localItems = appDatabase.getMenuItemDao().getMenuItems()
        if(localItems.isEmpty()) {
            val networkItems = littleLemonApi.getMenuData()
            localItems = networkItems.menu.map { it.toLocal() }
            appDatabase.getMenuItemDao().insertMenuItems(localItems)
        }
        emit(localItems)
    }.flowOn(Dispatchers.IO)
}