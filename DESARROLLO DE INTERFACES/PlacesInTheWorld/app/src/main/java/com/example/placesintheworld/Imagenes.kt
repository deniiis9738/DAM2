package com.example.placesintheworld

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.placesintheworld.ui.theme.PrimaryColor

@Composable
fun Imagenes(navController: NavController) {
    val listaImagenes = dameImagenes()
    val rvState = rememberLazyStaggeredGridState()
    var selectedItem by remember { mutableStateOf<ImagenDatos?>(null) }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(listaImagenes) { imagen ->
                    ImagenCard(
                        imagenDatos = imagen,
                        navController = navController,
                        onItemSelected = { selectedItem = imagen }
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImagenCard(
    imagenDatos: ImagenDatos,
    navController: NavController,
    onItemSelected: (ImagenDatos) -> Unit
) {
    Card(
        shape = RectangleShape,
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemSelected(imagenDatos)
                navController.navigate("Imagen/${imagenDatos.nombre}/${imagenDatos.imagen}")
            }
    ) {
        Box {
            Image(
                painter = painterResource(id = imagenDatos.imagen),
                contentDescription = imagenDatos.nombre,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )
            TopAppBar(
                title = {
                    Text(
                        text = imagenDatos.nombre,
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

fun dameImagenes(): List<ImagenDatos> {
    return listOf(
        ImagenDatos(R.drawable.image1, "Imagen 1"),
        ImagenDatos(R.drawable.image2, "Imagen 2"),
        ImagenDatos(R.drawable.image3, "Imagen 3"),
        ImagenDatos(R.drawable.image4, "Imagen 4"),
        ImagenDatos(R.drawable.image5, "Imagen 5"),
        ImagenDatos(R.drawable.image6, "Imagen 6"),
        ImagenDatos(R.drawable.image7, "Imagen 7"),
        ImagenDatos(R.drawable.image8, "Imagen 8"),
    )
}