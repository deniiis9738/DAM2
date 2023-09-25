package com.example.playjuegosdib

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Preferences() {
    var estadoRadio by rememberSaveable { mutableStateOf<String?>(null) }
    var puntuacion by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Elige una opción:",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            MyRadioButton(estadoRadio) {
                    selectedOption -> estadoRadio = selectedOption
            }
            SimpleDiscreteSlider()
        }
        FloatingActionButton(estadoRadio)
    }
}

@Composable
fun MyRadioButton(estadoRadio: String?, onOptionSelected: (String) -> Unit) {
    Row(){
        RadioButton(
            selected = estadoRadio=="Angry Birds",
            onClick = { onOptionSelected("Angry Birds") })
        Text(
            text = "Angry Birds",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Dragon Fly",
            onClick = { onOptionSelected("Dragon Fly") }
        )
        Text(
            text = "Dragon Fly",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Hill Climbing Racing",
            onClick = { onOptionSelected("Hill Climbing Racing") })
        Text(
            text = "Hill Climbing Racing",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Pocket Soccer",
            onClick = { onOptionSelected("Pocket Soccer") }
        )
        Text(
            text = "Pocket Soccer",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Radiant Defense",
            onClick = { onOptionSelected("Radiant Defense") }
        )
        Text(
            text = "Radiant Defense",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Ninja Jump",
            onClick = { onOptionSelected("Ninja Jump") }
        )
        Text(
            text = "Ninja Jump",
            Modifier.padding(top = 12.dp)
        )
    }
    Row(){
        RadioButton(
            selected = estadoRadio=="Air Control",
            onClick = { onOptionSelected("Air Control") }
        )
        Text(
            text = "Air Control",
            Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun SimpleDiscreteSlider() {
    val range = 0.0f..100.0f
    val steps = 10
    var selection by remember { mutableStateOf(0f) }
    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = { selection = it }
    )
}

@Composable
fun FloatingActionButton(estadoRadio: String?, puntuacion: Int) {
    var context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                )
            },
            onClick = {
                if (estadoRadio != null) {
                    Toast.makeText(context, "Has seleccionado " + estadoRadio + " con una puntuación de " + puntuacion, Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(context, "No has pulsado ninguna opción", Toast.LENGTH_LONG)
                        .show()
                }
            },
            containerColor = Color.White,
            modifier = Modifier.size(70.dp)
                .clip(CircleShape)
        )
    }
}