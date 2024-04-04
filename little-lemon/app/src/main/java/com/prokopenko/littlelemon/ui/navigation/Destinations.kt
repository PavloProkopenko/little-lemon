package com.prokopenko.littlelemon.ui.navigation

sealed interface Destinations {
    fun getRoute() : String

    object Home : Destinations {
        override fun getRoute(): String {
            return "home"
        }
    }

    object Profile : Destinations {
        override fun getRoute(): String {
            return "profile"
        }
    }

    object Onboard : Destinations {
        override fun getRoute(): String {
            return "on_board"
        }
    }
}