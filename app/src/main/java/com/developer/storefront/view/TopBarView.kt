package com.developer.storefront.view

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.developer.storefront.R
import com.developer.storefront.navigation.Screen
import com.developer.storefront.viewmodel.CartPageViewModel

@Composable
fun TopBarView(
    navController: NavController,
    cartPageViewModel: CartPageViewModel
){

    TopAppBar(
        title = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                HeaderView()

                TextButton(onClick = {
                    navController.navigate(Screen.CartPage.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = "Go to cart",
                        modifier = Modifier.width(30.dp).height(30.dp)
                    )

                    Text(
                        text = "CART",
                        color = Color.White
                    )

                    Text(
                        text = cartPageViewModel.itemsCount.toString(),
                        color = Color.White
                    )
                }
            }
        },
        elevation = 3.dp,
        backgroundColor = Color.Blue
    )

}