package com.example.circle

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun Portada() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = Color.Magenta,
                center = Offset(canvasWidth / 2, canvasHeight / 2),
                radius = 400f,
                style = Stroke(15f)
            )

            drawPoints(
                points = listOf(Offset(canvasWidth / 2, canvasHeight / 2)),
                strokeWidth = 22f,
                color = Color.Cyan,
                pointMode = PointMode.Points
            )

            drawRect(
                color = Color.Green,
                size = size.copy(width = canvasWidth / 20, height = canvasHeight / 35),
                topLeft = Offset(canvasWidth / 10, canvasHeight / 1.1f),
            )

            drawRect(
                color = Color.Red,
                size = size.copy(width = canvasWidth / 20, height = canvasHeight / 35),
                topLeft = Offset(canvasWidth / 10, canvasHeight / 10),
            )

            drawRect(
                color = Color.Blue,
                size = size.copy(width = canvasWidth / 20, height = canvasHeight / 35),
                topLeft = Offset(canvasWidth / 1.2f, canvasHeight / 10),
            )

            drawRect(
                color = Color.Yellow,
                size = size.copy(width = canvasWidth / 20, height = canvasHeight / 35),
                topLeft = Offset(canvasWidth / 1.2f, canvasHeight / 1.1f),
            )
        }
    }
}
