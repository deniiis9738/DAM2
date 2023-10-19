package com.example.sol

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sol.ui.theme.Purple80

@Composable
fun Portada(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MyCards()

    }
}

@Composable
fun MyCards() {
    val dataSun = listOf(
        SunCardsClass(R.drawable.corona_solar, "Corona solar"),
        SunCardsClass(R.drawable.erupcionsolar, "Erupcion solar"),
        SunCardsClass(R.drawable.espiculas, "Espiculas"),
        SunCardsClass(R.drawable.filamentos, "Filamentos"),
        SunCardsClass(R.drawable.magnetosfera, "Magnetosfera"),
        SunCardsClass(R.drawable.manchasolar, "Mancha solar"),
    )

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(dataSun) { data ->
                    var isMenuExpanded by remember { mutableStateOf(false) }
                    var snackbarText by remember { mutableStateOf("") }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                snackbarText = data.text
                            },
                        colors = CardDefaults.cardColors(Purple80)
                    ) {
                        Image(
                            painter = painterResource(id = data.image),
                            contentDescription = data.text,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Row {
                            Text(
                                text = data.text,
                                modifier = Modifier.padding(10.dp)
                            )
                            IconButton(
                                onClick = {
                                    isMenuExpanded = true
                                },
                                content = {
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = "MoreVert",
                                    )
                                }
                            )
                                DropdownMenu(
                                    expanded = isMenuExpanded,
                                    onDismissRequest = {
                                        isMenuExpanded = false
                                    },
                                    modifier = Modifier.width(150.dp)
                                ) {
                                DropdownMenuItem(
                                    onClick = {
                                        isMenuExpanded = false
                                    },
                                    text = { Text(text = "Copiar") },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Add,
                                            contentDescription = "Copiar"
                                        )
                                    }
                                )
                                DropdownMenuItem(
                                    onClick = {
                                        isMenuExpanded = false
                                    },
                                    text = { Text(text = "Eliminar") },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Delete,
                                            contentDescription = "Eliminar"
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}