package com.developer.storefront.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developer.storefront.R

@Composable
fun HeaderView(){
    Row {
        Text(
            text = "SG.",
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(start = 4.dp)
                .fillMaxHeight(),
            fontSize = 40.sp
        )

        Column {
            Text(
                text = "TOURNAMENT",
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp),
                fontSize = 20.sp
            )
            Text(
                text = "CARDS",
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp),
                fontSize = 20.sp
            )
        }
    }
}