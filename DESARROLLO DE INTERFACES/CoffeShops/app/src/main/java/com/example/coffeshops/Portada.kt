package com.example.coffeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Portada(navController: NavController) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        MyCards()
    }
}

@Composable
fun MyCards() {
    var estado = 5.0
    Card {
        Image(
            painter = painterResource(id = R.drawable.images),
            contentDescription = "Antico Coffe Greco"
        )
        Text(
            text = "Antico Coffe Greco",
            fontSize = 13.sp,
        )
        RatingBar(
            rating = estado,
            onRatingChanged = {newRating -> estado = newRating}
        )
        Text(
            text = "St. Italy, Rome",
            fontSize = 13.sp,
        )
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 10,
    starsColor: Color = Color.Red,
    onRatingChanged: (Double) -> Unit
) {
    var estadoRating by remember { mutableStateOf(rating) }

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