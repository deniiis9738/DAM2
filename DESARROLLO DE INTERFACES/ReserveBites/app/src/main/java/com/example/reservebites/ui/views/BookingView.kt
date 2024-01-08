package com.example.reservebites.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reservebites.R

@Composable
fun BookingView() {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var reservationTime by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2C3E50),
                        Color(0xFF1F2A38)
                    )
                )
            )
            .padding(10.dp)
            .verticalScroll(scrollState),
    ) {
        Text(
            text = "Elige tú sitio favorito",
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            letterSpacing = 0.5.sp,
        )
        Image(
            painter = painterResource(id = R.drawable.disenio),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        BookingTextField("Nombre y Apellidos", name) {
            name = it
        }
        BookingTextField("Número de Teléfono", phoneNumber) {
            phoneNumber = it
        }
        BookingTextField("Correo Electrónico", email) {
            email = it
        }
        BookingTextField("Hora de Reserva", reservationTime) {
            reservationTime = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reservar")
        }
    }
}

@Composable
private fun BookingTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}