package com.example.mywhatsapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Chats() {
    val dataClass = listOf(
        DataClass("Departamento Informática", R.drawable.photo, "Jefe de departamento"),
        DataClass("Departamento Informática", R.drawable.photo1, "Tutora DAM"),
        DataClass("Departamento Informática", R.drawable.photo8, "Tutora DAW"),
        DataClass("Departamento Informática", R.drawable.photo9, "Tutora ASIX"),
        DataClass("Departamento Propietarios", R.drawable.photo2, "Presidenta"),
        DataClass("Departamento Propietarios", R.drawable.photo3, "Secretaria"),
        DataClass("Departamento Propietarios", R.drawable.photo4, "Administrador"),
        DataClass("Gimnasio", R.drawable.photo5, "Entrenadora"),
        DataClass("Gimnasio", R.drawable.photo6, "Nutricionista"),
        DataClass("Gimnasio", R.drawable.photo7, "Fisioterapeuta"),
    )

    val chats: Map<String, List<DataClass>> = dataClass.groupBy { it.grupo }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            chats.forEach { (grupo, data) ->
                stickyHeader {
                    Text(
                        text = grupo,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray),
                        fontSize = 16.sp
                    )
                }
                items(data) { data ->
                    var expanded by remember { mutableStateOf(false) }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = data.image),
                            contentDescription = data.title,
                            modifier = Modifier
                                .size(75.dp)
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            modifier = Modifier.pointerInput(Unit) {
                            detectTapGestures { offset ->
                                if (offset != Offset(0f, 0f)) {
                                    expanded = true
                                }
                            }
                        }
                        ) {
                            Spacer(modifier = Modifier.height(25.dp))
                            Text(text = data.title)
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                DropdownMenuItem(
                                    text = { Text(text = "Salir del grupo") },
                                    onClick = { /*TODO*/ }
                                )
                                DropdownMenuItem(
                                    text = { Text(text = "Info. grupo") },
                                    onClick = { /*TODO*/ }
                                )
                                DropdownMenuItem(
                                    text = { Text(text = "Crear acceso directo") },
                                    onClick = { /*TODO*/ }
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}