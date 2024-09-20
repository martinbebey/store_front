package com.developer.storefront.view

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.developer.storefront.R
import com.developer.storefront.model.Product

@Composable
fun CartItemView(
    product: Product,
    onDeleteClick: () -> Unit
) {

    Column {
        Divider(color = Color.Blue)

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.image),
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .padding(8.dp)
            )

            Column {
                Text(
                    text = product.title,
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = product.category,
                    color = Color.Black
                )

                Row {

                    IconButton(onClick = {
                        //TODO
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_minus),
                            contentDescription = "minus"
                        )
                    }

                    Text(
                        text = product.quantity.toString(),
                        color = Color.Black
                    )

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "plus"
                        )
                    }

                    IconButton(onClick = onDeleteClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "trash"
                        )
                    }
                }
            }
            
            Text(text = product.price)
        }
    }

}