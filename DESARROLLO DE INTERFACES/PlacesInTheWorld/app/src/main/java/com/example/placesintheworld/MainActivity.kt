package com.example.placesintheworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.placesintheworld.ui.theme.PlacesInTheWorldTheme
import com.example.placesintheworld.ui.theme.SecondaryColor

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlacesInTheWorldTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = { FAB(navController = navController) },
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "Portada"
                        ) {
                            composable("Portada") {
                                Portada(navController)
                            }
                            composable("Plazas") {
                                Plazas(navController)
                            }
                            composable("Imagenes") {
                                Imagenes(navController)
                            }
                            composable(
                                route = "Plaza/{nombrePlaza}/{imagenPlaza}",
                                arguments = listOf(
                                    navArgument("nombrePlaza") { type = NavType.StringType },
                                    navArgument("imagenPlaza") { type = NavType.IntType }
                                )

                            ) { navBackStackEntry ->
                                val nombrePlaza = navBackStackEntry.arguments?.getString("nombrePlaza") ?: ""
                                val imagenPlaza = navBackStackEntry.arguments?.getInt("imagenPlaza") ?: 0
                                Plaza(nombrePlaza, imagenPlaza)
                            }
                            composable(
                                route = "Imagen/{nombreImagen}/{imagenImagen}",
                                arguments = listOf(
                                    navArgument("nombreImagen") { type = NavType.StringType },
                                    navArgument("imagenImagen") { type = NavType.IntType }
                                ),
                                enterTransition = {
                                    slideIntoContainer(
                                        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                                        animationSpec = tween(700)
                                    )
                                },
                                exitTransition = {
                                    fadeOut(
                                        animationSpec = tween(2000)
                                    )
                                },

                            ) { navBackStackEntry ->
                                val nombreImagen = navBackStackEntry.arguments?.getString("nombreImagen") ?: ""
                                val imagenImagen = navBackStackEntry.arguments?.getInt("imagenImagen") ?: 0
                                Imagen(nombreImagen, imagenImagen)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FAB(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = 10.dp,
                bottom = 10.dp
            ),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { navController.navigate("Portada") },
            containerColor = SecondaryColor
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "ArrowBack",
                tint = Color.White
            )
        }
    }
}