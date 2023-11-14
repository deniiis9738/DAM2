package com.example.placesintheworld

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.placesintheworld.ui.theme.Orange700
import com.example.placesintheworld.ui.theme.PrimaryColor
import com.example.placesintheworld.ui.theme.SecondaryColor
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
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        PrimaryColor,
                        SecondaryColor,
                        Color.White
                    )
                )
            )
    ) {
        var estadoRotacion by remember { mutableStateOf(0f) }
        var estadoEscalado by remember { mutableStateOf(1f) }
        var estadoEfectoAlfa by remember { mutableStateOf(1f) }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = nombrePlaza,
            fontFamily = saltyOcean,
            color = Color.White,
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(350.dp)
        ) {
            Image(
                painter = painterResource(id = imagenPlaza),
                contentDescription = nombrePlaza,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        scaleX = estadoEscalado,
                        scaleY = estadoEscalado,
                        alpha = estadoEfectoAlfa,
                        rotationY = estadoRotacion
                    ),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.width(275.dp)
        ) {
            Text(
                text = "Rotación",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Slider(
                value = estadoRotacion,
                onValueChange = { estadoRotacion = it },
                colors = SliderDefaults.colors(
                    thumbColor = Orange700,
                    activeTrackColor = Orange700,
                    inactiveTrackColor = Color.White
                ),
                valueRange = 0.0f..360.0f, steps = 360
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.width(275.dp)
        ) {
            Text(
                text = "Escalado",
                color = Color.White,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Slider(
                value = estadoEscalado,
                onValueChange = { estadoEscalado = it },
                colors = SliderDefaults.colors(
                    thumbColor = Orange700,
                    activeTrackColor = Orange700,
                    inactiveTrackColor = Color.White
                ),
                valueRange = 0.0f..10.0f, steps = 360
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.width(275.dp)
        ) {
            Text(
                text = "Efecto Alfa",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Slider(
                value = estadoEfectoAlfa,
                onValueChange = { estadoEfectoAlfa = it },
                colors = SliderDefaults.colors(
                    thumbColor = Orange700,
                    activeTrackColor = Orange700,
                    inactiveTrackColor = Color.White
                ),
                valueRange = 0.0f..1.0f, steps = 360
            )
        }
    }
}