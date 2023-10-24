@file:Suppress("UNUSED_EXPRESSION")

package com.example.coffeshops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeshops.ui.theme.CoffeShopsTheme
import com.example.coffeshops.ui.theme.Pink300

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeShopsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar()}
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "Portada") {
                            composable("Portada") {
                                Portada(navController)
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
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Coffee") },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Pink300),
        actions = {
            IconButton(
                onClick = { showMenu = !showMenu },
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "MoreVert",
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(
                    onClick = { showMenu },
                    text = { Text(text = "Compartir") },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir") }
                )
                DropdownMenuItem(
                    onClick = { showMenu },
                    text = { Text(text = "Álbum") },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Álbum") }
                )
            }
        }
    )
}