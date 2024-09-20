package com.developer.storefront.view

import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developer.storefront.navigation.StoreFrontNavigation
import com.developer.storefront.ui.theme.StoreFrontTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageView(){

    val controller: NavController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                Text(text = "SG. TOURNAMENT CARDS ")
            }
            )
        },
        scaffoldState = scaffoldState
    ){
        Text(text = it.toString())
    }
}