package com.developer.storefront.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.developer.storefront.R
import com.developer.storefront.viewmodel.CartPageViewModel

@Composable
fun CartPageView(
    navController: NavController,
    viewModel: CartPageViewModel
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopBarView(navController = navController)
        },
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text(text = "SHOP > MY CART")

            Text(
                text = "MY CART",
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            val cartItemsList = viewModel.getAllCartItems.collectAsState(initial = listOf())
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(cartItemsList.value, key = { cartItem -> cartItem.id }) { product ->
                    CartItemView(
                        product = product,
                        onDeleteClick = {viewModel.deleteACartItem(product)}
                    )
                }

                item {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "SUBTOTAL: $000.00",
                            color = Color.Black,
                            style = MaterialTheme.typography.h5
                        )

                        Button(onClick = { /*TODO*/ }) {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_cart),
                                    contentDescription = "Go to cart",
                                    modifier = Modifier.width(30.dp).height(30.dp).padding(8.dp)
                                )

                                Text(
                                    text = "Checkout",
                                    color = Color.White,
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
                            }
                        }

                        Text(text = "We will send you your card bundles two weeks after the tournament ends so we can verify the stats and images.")

                        Image(
                            painter = painterResource(id = R.drawable.ic_stripe),
                            contentDescription = "stripe logo",
                            modifier = Modifier.width(250.dp).height(250.dp)
                        )

                        BottomPageView()
                    }
                }
            }
        }
    }

}