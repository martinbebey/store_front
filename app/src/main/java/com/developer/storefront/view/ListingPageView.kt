package com.developer.storefront.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import com.developer.storefront.model.ListingViewState
import com.developer.storefront.model.Product
import com.developer.storefront.viewmodel.CartPageViewModel
import com.developer.storefront.viewmodel.ListingPageViewModel

@Composable
fun ListingPageView(
    navigateToDetailScreen: (Product) -> Unit,
    navController: NavController,
    listingViewState: ListingViewState,
    cartPageViewModel: CartPageViewModel
) {

    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()

    Box() {
        when (listingViewState) {
            is ListingViewState.Loading -> {
//                    CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            is ListingViewState.Error -> {
                Text(text = listingViewState.error, color = Color.Red)
            }

            is ListingViewState.Success -> {

                Scaffold(
                    topBar = {
                        TopBarView(navController = navController, cartPageViewModel = cartPageViewModel)
                    },
                    scaffoldState = scaffoldState,
                ) {
                    Column {
                        LazyColumn(modifier = Modifier
                            .padding(it)
                        ) {
                            items(listingViewState.productList) { productFromList ->
                                ListingPageItem(
                                    product = productFromList,
                                    navigateToDetailScreen = navigateToDetailScreen
                                )
                            }

                            item {
                                BottomPageView()
                            }
                        }

//+98
//


                    }


                }

            }
        }
//
    }
}