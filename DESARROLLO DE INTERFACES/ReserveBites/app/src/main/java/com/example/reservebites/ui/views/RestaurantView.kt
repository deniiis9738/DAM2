package com.example.reservebites.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reservebites.data.models.RestaurantCard
import com.example.reservebites.ui.viewmodels.RestaurantViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun RestaurantView(restaurantCard: RestaurantCard, restaurantViewModel: RestaurantViewModel) {
    val reviewsList by restaurantViewModel.reviewsList.observeAsState()

    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
    ) {
        item {
            Text(
                text = restaurantCard.name,
                modifier = Modifier.padding(10.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = restaurantCard.image),
                contentDescription = restaurantCard.name,
                modifier = Modifier.height(300.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = restaurantCard.description,
                modifier = Modifier.padding(top = 15.dp),
                textAlign = TextAlign.Justify
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
                text = "Reviews",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        items(reviewsList ?: emptyList()) { review ->
            Text(
                text = "Persona ${reviewsList?.indexOf(review)}:",
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
            Text(text = review)
        }
    }
}