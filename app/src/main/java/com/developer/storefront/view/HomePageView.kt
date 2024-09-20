package com.developer.storefront.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.developer.storefront.R
import com.developer.storefront.navigation.Screen
import com.developer.storefront.navigation.StoreFrontNavigation
import com.developer.storefront.ui.theme.StoreFrontTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageView(
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()


    Scaffold(
        topBar = {
            TopBarView(navController = navController)
        },
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_page_image),
                contentDescription = "Home Page Image",
                modifier = Modifier
                    .fillMaxSize()
            )

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(it)
            ) {
                Text(text = "SPORT GROUP \n TOURNAMENT CARDS")

                Text(text = "Collect unique baseball cards to showcase your favorite future all-star stats each tournament.")

                Button(onClick = {
                    navController.navigate(Screen.ListingPage.route)
                }) {
                    Text(text = "Shop Now")
                }
            }

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseball),
                        contentDescription = "Home Page Image"
                    )

                    Column {
                        Text(text = "SELECT A PLAYER")

                        Text(text = "Choose the player you want official SG baseball cards for.")
                    }
                }

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_camera_lens),
                        contentDescription = "Home Page Image"
                    )

                    Column {
                        Text(text = "SELECT A PLAYER")

                        Text(text = "Choose the player you want official SG baseball cards for.")
                    }
                }

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_trophy),
                        contentDescription = "Home Page Image"
                    )

                    Column {
                        Text(text = "SELECT A PLAYER")

                        Text(text = "Choose the player you want official SG baseball cards for.")
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.baseball_frame),
                contentDescription = "Home Page Image",
                modifier = Modifier.fillMaxWidth()
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(text = "GET STARTED")

                Text(text = "At every event, we take the opportunity to capture photos of all our players attending. We use these photos to create each player's one-of-a-kind personal baseball cards fitted with all their stats for each tournament. Make sure to get your custom card bundles of your favorite player for all the SG events they are in. ")

                Button(onClick = {
                    navController.navigate(Screen.ListingPage.route)
                }) {
                    Text(text = "Shop Now")
                }
            }

            BottomPageView()
        }
    }
}