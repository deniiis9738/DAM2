package com.example.examen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
    var selectedItem by remember { mutableStateOf<PlaceDataClass?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(listaDatos) { place ->
                    PlaceCard(
                        place,
                        navController,
                        onItemSelected = { selectedItem = place }
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceCard(
    placeDataClass: PlaceDataClass,
    navController: NavController,
    onItemSelected: (PlaceDataClass) -> Unit
) {
    Card(
        shape = RectangleShape,
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier
            .fillMaxHeight()
            .clickable {
                onItemSelected(placeDataClass)
                navController.navigate("Plaza/${placeDataClass.nombre}/${placeDataClass.imagen}")
            },
    ) {
        Box {
            Image(
                painter = painterResource(id = placeDataClass.imagen),
                contentDescription = placeDataClass.nombre,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            TopAppBar(
                title = {
                    Text(
                        text = placeDataClass.nombre,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Black.copy(alpha = 0.3f)),
            )
        }
    }
}

fun dameDatos(): List<PlaceDataClass> {
    return listOf(
        PlaceDataClass(R.drawable.morella, "Morella"),
        PlaceDataClass(R.drawable.lugo, "Lugo"),
        PlaceDataClass(R.drawable.bangkok, "Bangkok"),
        PlaceDataClass(R.drawable.peru, "Perú"),
        PlaceDataClass(R.drawable.pekin, "Pekín"),
        PlaceDataClass(R.drawable.granada, "Granada"),
    )
}