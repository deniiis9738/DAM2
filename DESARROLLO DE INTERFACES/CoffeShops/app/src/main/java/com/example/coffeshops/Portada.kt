package com.example.coffeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeshops.ui.theme.Pink100
import com.example.coffeshops.ui.theme.alviaregular

@Composable
fun Portada(navController: NavController) {
    var selectedItem by remember { mutableStateOf<DataShops?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MyCards(navController, onItemSelected = {selectedItem = it})
    }
}

@Composable
fun MyCards(navController: NavController, onItemSelected: (DataShops) -> Unit) {
    val dataShops = listOf(
        DataShops(R.drawable.images, "Antico Coffe Greco", "St. Italy, Rome"),
        DataShops(R.drawable.images1, "Coffee Room", "St. Germany, Berlin"),
        DataShops(R.drawable.images2, "Coffe Ibiza", "St. Colon, Madrid"),
        DataShops(R.drawable.images3, "Pudding Coffe Shop", "St. Diagonal, Barcelona"),
        DataShops(R.drawable.images4, "L'Express", "St. Picadilly Circus, London"),
        DataShops(R.drawable.images5, "Coffe Corner", "St. Àngel Guimerà, Valencia"),
        DataShops(R.drawable.images6, "Sweet Cup", "St. Kinkerstraat, Amsterdam")
    )

    var estado = 0.0

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            items(dataShops) { data ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            onItemSelected(data)
                            navController.navigate("CommentCoffee/${data.title}")
                        },
                    colors = CardDefaults.cardColors(Pink100)
                ) {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = data.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = data.title,
                        fontSize = 25.sp,
                        fontFamily = alviaregular,
                        modifier = Modifier.padding(10.dp)
                    )
                    RatingBar(
                        rating = estado,
                        onRatingChanged = { newRating ->
                            estado = newRating
                        },
                        modifier = Modifier.padding(10.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = data.direction,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                    Divider()
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(
                            text = "RESERVE",
                            color = Color.Magenta
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Red,
    onRatingChanged: (Double) -> Unit
) {
    var estadoRating by remember { mutableDoubleStateOf(rating) }

    Row(
        modifier = modifier,
    ) {
        for (i in 1..stars) {
            val filled = i <= estadoRating
            Icon(
                imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (filled) starsColor else Color.Gray,
                modifier = Modifier.clickable {
                    estadoRating = i.toDouble()
                    onRatingChanged(estadoRating)
                }
            )
            Spacer(modifier = Modifier.width(13.dp))
        }
    }
}