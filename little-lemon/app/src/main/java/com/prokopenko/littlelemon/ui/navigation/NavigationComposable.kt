package com.prokopenko.littlelemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prokopenko.littlelemon.ui.screen.HomeScreen
import com.prokopenko.littlelemon.ui.screen.Onboarding
import com.prokopenko.littlelemon.ui.screen.ProfileScreen


@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Destinations.Onboard.getRoute()){
        composable(route = Destinations.Onboard.getRoute()) {
            Onboarding(navHostController)
        }

        composable(route = Destinations.Home.getRoute()) {
            HomeScreen()
        }

        composable(route = Destinations.Profile.getRoute()) {
            ProfileScreen()
        }
    }
}