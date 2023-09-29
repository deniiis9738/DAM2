package com.example.playjuegosdib

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Preferences() {
    var estadoRadio by rememberSaveable { mutableStateOf<String?>(null) }
    var puntuacion by remember { mutableStateOf(0f) }
    var estadoFilterChip by rememberSaveable { mutableStateOf<String?>(null) }
    var estadoRating by remember { mutableStateOf(0.0) }

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
            SimpleDiscreteSlider(puntuacion) {
                sliderValue -> puntuacion = sliderValue
            }
            RatingBar(
                rating = estadoRating,
                onRatingChanged = {newRating -> estadoRating = newRating}
            )
            FilterChips(estadoFilterChip) {
                selectedOption -> estadoFilterChip = selectedOption
            }
        }
        SmallFAB(estadoRating, estadoRadio)
        FloatingActionButton(estadoRadio, puntuacion)
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
fun SimpleDiscreteSlider(puntuacion: Float, onSliderValueChanged: (Float) -> Unit) {
    val range = 0.0f..10.0f
    val steps = 10
    var selection by remember { mutableStateOf(puntuacion) }
    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = {
            selection = it
            onSliderValueChanged(it)
                        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun FloatingActionButton(estadoRadio: String?, puntuacion: Float) {
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
                    Toast.makeText(context, "Has seleccionado $estadoRadio con una puntuación de $puntuacion", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(context, "No has pulsado ninguna opción", Toast.LENGTH_LONG)
                        .show()
                }
            },
            containerColor = Color.White,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(estadoFilterChip: String?, onOptionSelected: (String) -> Unit) {
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Plataformas:",
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            FilterChip(
                selected = estadoFilterChip=="PS4",
                onClick = {
                    Toast.makeText(context, "Has seleccionado PS4", Toast.LENGTH_LONG)
                    .show()
                    onOptionSelected("PS4")
                          },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (estadoFilterChip == "PS4") {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.Black,
                            )
                        }
                        Text(text = "PS4")
                    }
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            FilterChip(
                selected = estadoFilterChip=="XBOX",
                onClick = {
                    Toast.makeText(context, "Has seleccionado XBOX", Toast.LENGTH_LONG)
                        .show()
                    onOptionSelected("XBOX")
                },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (estadoFilterChip == "XBOX") {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "",
                                tint = Color.Black,
                            )
                        }
                        Text(text = "XBOX")
                    }
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            FilterChip(
                selected = estadoFilterChip=="3DS",
                onClick = {
                    Toast.makeText(context, "Has seleccionado 3DS", Toast.LENGTH_LONG)
                        .show()
                    onOptionSelected("3DS")
                },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (estadoFilterChip == "3DS") {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "",
                                tint = Color.Black,
                            )
                        }
                        Text(text = "3DS")
                    }
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            FilterChip(
                selected = estadoFilterChip=="WII",
                onClick = {
                    Toast.makeText(context, "Has seleccionado WII", Toast.LENGTH_LONG)
                        .show()
                    onOptionSelected("WII")
                },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (estadoFilterChip == "WII") {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "",
                                tint = Color.Black,
                            )
                        }
                        Text(text = "WII")
                    }
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            FilterChip(
                selected = estadoFilterChip=="WIIU",
                onClick = {
                    Toast.makeText(context, "Has seleccionado WIIU", Toast.LENGTH_LONG)
                        .show()
                    onOptionSelected("WIIU")
                },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (estadoFilterChip == "WIIU") {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "",
                                tint = Color.Black,
                            )
                        }
                        Text(text = "WIIU")
                    }
                }
            )
        }
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

@Composable
fun SmallFAB(estadoRating: Double, estadoRadio: String?) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .offset(300.dp, 580.dp)
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                )
            },
            onClick = {
                if (estadoRadio != null) {
                    Toast.makeText(context, "Has seleccionado $estadoRadio con una puntuación de $estadoRating", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(context, "No has pulsado ninguna opción", Toast.LENGTH_LONG)
                        .show()
                }
            },
            containerColor = Color.White,
            modifier = Modifier
                .size(55.dp)
        )
    }
}