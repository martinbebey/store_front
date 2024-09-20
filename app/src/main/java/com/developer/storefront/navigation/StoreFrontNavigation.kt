package com.developer.storefront.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developer.storefront.model.Product
import com.developer.storefront.view.CartPageView
import com.developer.storefront.view.HomePageView
import com.developer.storefront.view.ListingPageView
import com.developer.storefront.view.ProductDescriptionPageView
import com.developer.storefront.viewmodel.ListingPageViewModel

@Composable
fun StoreFrontNavigation(
){

    val navController = rememberNavController()
    val listingPageViewModel: ListingPageViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.HomePage.route,
    ){
        composable(route = Screen.HomePage.route){
            HomePageView(navController = navController)
        }

        composable(route = Screen.ListingPage.route){
            ListingPageView(
                navController = navController,
                listingViewState = listingPageViewModel.listingViewState.value,
                navigateToDetailScreen = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("product", it)
                    navController.navigate(Screen.ProductDescriptionPage.route)
                }
            )
        }

        composable(route = Screen.ProductDescriptionPage.route){
            val product = navController.previousBackStackEntry?.savedStateHandle?.get<Product>("product")?: Product("", "", "", "", "", "")
            ProductDescriptionPageView(product = product, navController = navController)
        }

        composable(route = Screen.CartPage.route){
            CartPageView()
        }
    }
}