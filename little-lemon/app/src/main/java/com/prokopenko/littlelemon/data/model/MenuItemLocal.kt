package com.prokopenko.littlelemon.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_items")
data class MenuItemLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "image")
    val image: String = "",
    @ColumnInfo(name = "price")
    val price: String = "",
    @ColumnInfo(name = "description")
    val description: String = "",
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "category")
    val category: String = ""
)