package com.example.myprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.myprojects.ui.theme.Pink40

@Composable
fun PortadaMyProjects() {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Pink40),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "MyProjects",
            fontSize = 50.sp
        )
    }
}