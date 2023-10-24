package com.example.sol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sol.ui.theme.Purple80
import com.example.sol.ui.theme.PurpleGrey80
import com.example.sol.ui.theme.RedA700
import com.example.sol.ui.theme.SolTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomBar(drawerState)}
                ) {
                    Column {
                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            drawerContent = {
                                ModalDrawerSheet(
                                    drawerContainerColor = PurpleGrey80,
                                ) {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.solcongafas),
                                            contentDescription = "solcongafas",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .height(300.dp)
                                                .fillMaxWidth()
                                        )
                                        NavigationDrawerItem(
                                            icon = { Icon(imageVector = Icons.Filled.Build, contentDescription = null) },
                                            label = { Text(text = "Build") },
                                            selected = false,
                                            onClick = {
                                                navController.navigate("Portada")
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                                      },
                                            modifier = Modifier.padding(10.dp)
                                        )
                                        NavigationDrawerItem(
                                            icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = null) },
                                            label = { Text(text = "Info") },
                                            selected = false,
                                            onClick = {
                                                navController.navigate("Info")
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                                      },
                                            modifier = Modifier.padding(10.dp)
                                        )
                                        NavigationDrawerItem(
                                            icon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
                                            label = { Text(text = "Email") },
                                            selected = false,
                                            onClick = {
                                                navController.navigate("Info")
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                            },
                                            modifier = Modifier.padding(10.dp)
                                        )
                                    }
                                }
                            },
                            content = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = it.calculateBottomPadding())
                                ) {
                                    NavHost(
                                        navController = navController,
                                        startDestination = "Portada"
                                    ) {
                                        composable("Portada") {
                                            Portada(navController)
                                        }
                                        composable("Info") {
                                            Info()
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(drawerState: DrawerState) {
    var badgeCount by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()


    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = RedA700,
        actions = {
            IconButton(
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "ArrowBack",
                    tint = Color.White
                )
            }
            BadgedBox(
                badge = {
                    if (badgeCount >= 0) {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .padding(4.dp)
                        ) {
                            Text(
                                text = badgeCount.toString(),
                                color = Color.White,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                },
                modifier = Modifier
            ) {
                IconButton(
                    onClick = {
                        badgeCount++
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
            }
            FloatingActionButton()
        }
    )
}

@Composable
fun FloatingActionButton() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                )
            },
            onClick = {},
            containerColor = Purple80,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
    }
}