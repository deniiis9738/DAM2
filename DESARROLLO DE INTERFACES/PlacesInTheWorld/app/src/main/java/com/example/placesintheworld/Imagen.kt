package com.example.placesintheworld

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.palette.graphics.Palette
import com.example.placesintheworld.ui.theme.PrimaryColor

@Composable
fun Imagen(
    nombreImagen: String,
    imagenImagen: Int
) {
    val context = LocalContext.current
    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, imagenImagen)
    }
    val palette = remember {
         Palette.from(bitmap).generate()
    }

    val lightVibrantSwatch = palette.lightVibrantSwatch
    val darkVibrantSwatch = palette.darkVibrantSwatch
    val lightMutedSwatch = palette.lightMutedSwatch
    val mutedSwatch = palette.mutedSwatch
    val darkMutedSwatch = palette.darkMutedSwatch

    val activity = context as? ComponentActivity
    activity?.let{
        it.window.statusBarColor = darkVibrantSwatch?.let { Color(it.rgb).toArgb() } ?: Color.Red.toArgb()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBarImagenes(palette)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            Image(
                painter = painterResource(id = imagenImagen),
                contentDescription = nombreImagen,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(lightVibrantSwatch?.let { Color(it.rgb) } ?: Color.Transparent)
        ) {
            Text(
                text = "Light Vibrant",
                color = lightVibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(darkVibrantSwatch?.let { Color(it.rgb) } ?: Color.Transparent)
        ) {
            Text(
                text = "Dark Vibrant",
                color = darkVibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(lightMutedSwatch?.let { Color(it.rgb) } ?: Color.Transparent)
        ) {
            Text(
                text = "Light Muted",
                color = lightMutedSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(mutedSwatch?.let { Color(it.rgb) } ?: Color.Transparent)
        ) {
            Text(
                text = "Muted",
                color = mutedSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(darkMutedSwatch?.let { Color(it.rgb) } ?: Color.Transparent)
        ) {
            Text(
                text = "Dark Muted",
                color = darkMutedSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
                )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarImagenes(
    palette: Palette,
    ) {
    val vibrantSwatch = palette.vibrantSwatch
    val darkVibrantSwatch = palette.darkVibrantSwatch

    TopAppBar(
        title = { Text(
            text = "Palette",
            color = darkVibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Black
        ) },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(vibrantSwatch?.let { Color(it.rgb) } ?: Color.Transparent),
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "MoreVert",
                    tint = Color.White
                )
            }
        }
    )
}