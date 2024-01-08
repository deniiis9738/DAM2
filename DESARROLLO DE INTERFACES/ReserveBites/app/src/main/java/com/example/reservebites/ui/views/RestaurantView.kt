package com.example.reservebites.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reservebites.data.models.RestaurantCard
import com.example.reservebites.ui.viewmodels.RestaurantViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun RestaurantView(restaurantCard: RestaurantCard, restaurantViewModel: RestaurantViewModel, navController: NavController) {
    val reviewsList by restaurantViewModel.reviewsList.observeAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2C3E50),
                        Color(0xFF1F2A38)
                    )
                )
            )
            .padding(10.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            item {
                Text(
                    text = restaurantCard.name,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 0.5.sp,
                )
                Image(
                    painter = painterResource(id = restaurantCard.image),
                    contentDescription = restaurantCard.name,
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = "Descripción:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 15.dp)
                )

                Text(
                    text = restaurantCard.description,
                    fontSize = 16.sp,
                    color = Color.White, // Color ajustado según preferencia
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
                val singapore = LatLng(1.35, 103.87)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(singapore, 10f)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = singapore),
                            title = "Singapore",
                            snippet = "Marker in Singapore"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Reviews:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Start,
                )
            }
            itemsIndexed(reviewsList ?: emptyList()) { index, review ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Persona ${index + 1}:",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        ),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = review,
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
            }
        }
        FloatingActionButton(navController)
    }
}

@Composable
private fun FloatingActionButton(navController: NavController) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                navController.navigate("BookingView")
            },
            modifier = Modifier
                .padding(16.dp)
                .height(60.dp)
                .width(100.dp),
            content = {
                Text(
                    text = "Reservar",
                    color = Color.White,
                )
            },
            containerColor = Color(0xFF071B29),
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        )
    }
}