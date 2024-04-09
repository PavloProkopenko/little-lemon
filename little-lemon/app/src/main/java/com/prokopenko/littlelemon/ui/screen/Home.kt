package com.prokopenko.littlelemon.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prokopenko.littlelemon.R
import com.prokopenko.littlelemon.ui.navigation.Destinations
import com.prokopenko.littlelemon.viewmodel.HomeVM

@Composable
fun HomeScreen(navController: NavController, homeVM: HomeVM = viewModel()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeScreenUI(navController = navController)
        val result = homeVM
            .menuData
            .collectAsStateWithLifecycle()
            .value
        Text(text = result.toString())
    }
}

@Composable
fun HomeScreenUI(navController: NavController) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo) ,
            contentDescription = "Little lemon logo",
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, start = 50.dp)
                .height(50.dp)
                .weight(1F, true))

        Image(
            painter = painterResource(id = R.drawable.profile) ,
            contentDescription = "profile",
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .size(50.dp)
                .clickable {
                    navController.navigate(Destinations.Profile.getRoute())
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreenUI(rememberNavController())
}