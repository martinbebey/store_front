package com.developer.storefront.view

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.developer.storefront.R
import com.developer.storefront.model.Product
import com.developer.storefront.navigation.Screen

@Composable
fun ProductDescriptionPageView(
    product: Product,
    navController: NavController
){

    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopBarView(navController = navController)
        },
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize().fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.padding(it).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "SHOP > ${product.title}")

                Image(
                    painter = rememberAsyncImagePainter(product.image),
                    contentDescription = "product image",
                    modifier = Modifier
                        .width(480.dp)
                        .height(480.dp)
                )

                Text(
                    text = product.title,
                    style = TextStyle(fontWeight = FontWeight.Bold)

                )

                Text(text = "Player Name")

                Text(
                    text = "$${product.price}",
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.review_stars),
                        contentDescription = "Home Page Image"
                    )

                    Text(
                        text = "82 Reviews",
                        color = Color.Blue
                    )
                }

                Text(text = product.description)

                Button(onClick = {
                    //TODO
                }) {
                    Text(text = "Add to Cart")
                }
            }


            BottomPageView()
        }
    }

}