@file:Suppress("UNUSED_EXPRESSION")

package com.example.sol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sol.ui.theme.Purple80
import com.example.sol.ui.theme.RedA700
import com.example.sol.ui.theme.SolTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomBar() }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "Portada") {
                            composable("Portada") {
                                Portada(navController)
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
fun BottomBar() {
    var badgeCount by remember { mutableStateOf(0) }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = RedA700,
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "ArrowBack",
                    tint = Color.White
                )
            }
            BadgedBox(
                badge = {
                    if (badgeCount > 0) {
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