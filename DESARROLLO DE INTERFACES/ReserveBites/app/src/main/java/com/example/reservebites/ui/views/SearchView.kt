package com.example.reservebites.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.reservebites.ui.viewmodels.LoginViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchView(navController: NavController, loginViewModel: LoginViewModel) {
    Column(

    ) {
        Text(text = "Search")
    }
}