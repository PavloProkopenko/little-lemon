package com.prokopenko.littlelemon.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetworkData(
    @SerialName("menu")
    val menu: List<MenuItem>
)