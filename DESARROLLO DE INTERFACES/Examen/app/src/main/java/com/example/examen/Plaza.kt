package com.example.examen

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
import com.example.examen.ui.theme.PrimaryColor
import com.example.examen.ui.theme.saltyOcean

@Composable
fun Plaza(nombrePlaza: String, imagenLugar: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Text(
            text = nombrePlaza,
            fontSize = 42.sp,
            fontFamily = saltyOcean,
            color = Color.White
        )
        Image(
            painter = painterResource(id = imagenLugar),
            contentDescription = nombrePlaza,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}