package com.prokopenko.littlelemon.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    @SerialName("image")
    var image: String = "",
    @SerialName("price")
    var price: String = "",
    @SerialName("description")
    var description : String = "",
    @SerialName("id")
    var id : Int = 0,
    @SerialName("title")
    var title: String = "",
    @SerialName("category")
    var category: String = ""
)