package com.example.placesintheworld

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.placesintheworld.ui.theme.PrimaryColor
import com.example.placesintheworld.ui.theme.saltyOcean

@Composable
fun Plaza(
    nombrePlaza: String,
    imagenPlaza: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Text(
            text = nombrePlaza,
            fontFamily = saltyOcean,
            color = Color.White,
            fontSize =50.sp
        )
        Image(
            painter = painterResource(id = imagenPlaza),
            contentDescription = nombrePlaza,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}