package com.example.reservebites.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.HeartBroken
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reservebites.ui.viewmodels.ForYouViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForYouView(navController: NavController, forYouViewModel: ForYouViewModel) {
    val restaurantList by forYouViewModel.restaurantList.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(restaurantList ?: emptyList()) { restaurant ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .size(525.dp),
                colors = CardDefaults.cardColors(Color.White),
                onClick = {
                    navController.navigate("RestaurantView/${restaurant.name}")
                }
            ) {
                Text(
                    text = restaurant.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )
                Image(
                    painter = painterResource(id = restaurant.image),
                    contentDescription = restaurant.name,
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = restaurant.description,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    for (i in 1..5) {
                        val filled = i <= restaurant.valoration
                        Icon(
                            imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = null,
                            tint = if (filled) Color.Red else Color.Gray,
                        )
                        Spacer(modifier = Modifier.width(13.dp))
                    }
                    Spacer(modifier = Modifier.width(120.dp))
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.HeartBroken,
                            contentDescription = null
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}