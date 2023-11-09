package com.example.placesintheworld

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Portada(navController: NavController) {
    val rvState = rememberLazyStaggeredGridState()
    val listaDatos = dameDatos()
    var selectedItem by remember { mutableStateOf<PlazaDatos?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(listaDatos) { plaza ->
                    PlazaCard(
                        plazaDatos = plaza,
                        navController = navController,
                        onItemSelected = { selectedItem = plaza }
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlazaCard(
    plazaDatos: PlazaDatos,
    navController: NavController,
    onItemSelected: (PlazaDatos) -> Unit
) {
    Card(
        shape = RectangleShape,
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemSelected(plazaDatos)
                navController.navigate("Plaza/${plazaDatos.nombre}/${plazaDatos.imagen}")
            },
    ) {
        Box {
            Image(
                painter = painterResource(id = plazaDatos.imagen),
                contentDescription = plazaDatos.nombre,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            TopAppBar(
                title = {
                    Text(
                        text = plazaDatos.nombre,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Black.copy(alpha = 0.35f)),
            )
        }
    }
}

fun dameDatos(): List<PlazaDatos> {
    return listOf(
        PlazaDatos(R.drawable.morella, "Morella"),
        PlazaDatos(R.drawable.lugo, "Lugo"),
        PlazaDatos(R.drawable.bangkok, "Bangkok"),
        PlazaDatos(R.drawable.peru, "Peru"),
        PlazaDatos(R.drawable.pekin, "Pekin"),
        PlazaDatos(R.drawable.granada, "Granada"),
        PlazaDatos(R.drawable.atenas, "Atenas"),
        PlazaDatos(R.drawable.yucatan, "Yucatan"),
        PlazaDatos(R.drawable.seychelles, "Seychelles"),

    )
}