package com.example.reservebites

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reservebites.ui.theme.ReserveBitesTheme
import com.example.reservebites.viewmodels.LoginViewModel
import com.example.reservebites.views.LoginView
import com.example.reservebites.views.MainView

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReserveBitesTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "LoginView"
                    ) {
                        val loginView = LoginView()
                        val loginViewModel = LoginViewModel()
                        composable("LoginView") {
                            loginView.Login(navController, loginViewModel)
                        }
                        val mainView = MainView()
                        composable("MainView") {
                            mainView.Main(navController)
                        }
                    }
                }
            }
        }
    }
}