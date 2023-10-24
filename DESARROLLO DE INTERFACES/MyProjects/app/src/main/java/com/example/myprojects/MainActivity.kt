package com.example.myprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeshops.CommentCoffeeView
import com.example.coffeshops.PortadaCoffeeShops
import com.example.myprojects.MyPhotos.PortadaMyPhotos
import com.example.myprojects.ui.theme.MyProjectsTheme
import com.example.sol.PortadaSol

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProjectsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "PortadaMyProjects") {
                            composable("PortadaMyProjects") {
                                PortadaMyProjects()
                            }
                            composable("MyPhotos") {
                                PortadaMyPhotos()
                            }
                            composable("CoffeeShops") {
                                PortadaCoffeeShops(navController)
                            }
                            composable("Sol") {
                                PortadaSol(navController)
                            }
                            composable(
                                "CommentCoffee/{namecoffee}",
                                arguments = listOf(navArgument("namecoffee") {type = NavType.StringType})
                            ) {
                                    navBackStackEntry ->
                                val param = navBackStackEntry.arguments?.getString("namecoffee") ?: ""
                                CommentCoffeeView(param)
                            }
                        }
                        bottomNavigationBar(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun bottomNavigationBar(navController: NavController) {
    val items = listOf(
        DataClass(Icons.Filled.AccountBox, "MyPhotos", "MyPhotos"),
        DataClass(Icons.Filled.Favorite, "CoffeeShops", "CoffeeShops"),
        DataClass(Icons.Filled.Face, "Sol", "Sol")
    )

    var selectedItem by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        selectedItem = items.indexOf(item)
                        navController.navigate(item.route)
                              },
                    icon = { Icon(
                        imageVector = item.image,
                        contentDescription = item.text
                    ) },
                    label = { Text(text = item.text) }
                )
            }
        }
    }
}