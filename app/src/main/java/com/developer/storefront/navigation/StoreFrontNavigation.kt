package com.developer.storefront.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developer.storefront.view.HomePageView

@Composable
fun StoreFrontNavigation(
    navController: NavController = rememberNavController(),
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.HomePage.route,
    ){
        composable(Screen.HomePage.route){
            HomePageView()
        }
    }
}