package com.example.reservebites.ui.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reservebites.ui.viewmodels.ForYouViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForYouView(navController: NavController, forYouViewModel: ForYouViewModel) {
    val restaurantList by forYouViewModel.restaurantList.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xE6192734),
                        Color(0xE21E2B33)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(restaurantList ?: emptyList()) { restaurant ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .size(525.dp),
                colors = CardDefaults.cardColors(Color(0xFF1E2B33)),
                onClick = {
                    navController.navigate("RestaurantView/${restaurant.name}")
                },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 25.dp
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = restaurant.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = restaurant.image),
                        contentDescription = restaurant.name,
                        modifier = Modifier
                            .height(225.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = restaurant.description,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (i in 1..5) {
                            val filled = i <= restaurant.valoration
                            Icon(
                                imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.Star,
                                contentDescription = null,
                                tint = if (filled) Color.Yellow else Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        var isFavorite by remember { mutableStateOf(false) }
                        val context = LocalContext.current

                        IconButton(
                            onClick = {
                                isFavorite = !isFavorite
                                val message = if (isFavorite) "Restaurante añadido a favoritos" else "Restaurante eliminado de favoritos"
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .size(36.dp)
                        ) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Outlined.Favorite else Icons.Filled.Favorite,
                                contentDescription = null,
                                tint = if (isFavorite) Color.Red else Color.White
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}