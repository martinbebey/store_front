package com.developer.storefront.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.developer.storefront.R

@Composable
fun BottomPageView(){
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeaderView()
        
        Text(
            text = "Copyright 2024 Sport Group, USA",
            color = colorResource(id = R.color.white)
        )
        
        Row {
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    text = "Privacy Policy",
                    color = colorResource(id = R.color.white)
                )
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Terms & Conditions",
                    color = colorResource(id = R.color.white)
                )
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Cookie Policy",
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}