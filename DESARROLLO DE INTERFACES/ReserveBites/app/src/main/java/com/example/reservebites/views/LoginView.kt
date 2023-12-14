package com.example.reservebites.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reservebites.R
import com.example.reservebites.ui.theme.Brown
import com.example.reservebites.ui.theme.Gold
import com.example.reservebites.viewmodels.LoginViewModel

@Composable
fun LoginView(navController: NavController, loginViewModel: LoginViewModel) {
    val username by loginViewModel.username.observeAsState()
    val password by loginViewModel.password.observeAsState()
    val passwordVisibility by loginViewModel.passwordVisibility.observeAsState()

    Box {
        Image(
            painter = painterResource(id = R.drawable.restaurantelujoso),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ReserveBites",
                fontSize = 75.sp,
                fontFamily = loginViewModel.getFontFamily("Tangerine"),
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.width(155.dp)
                ) {
                    Text(
                        text = "Username",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(15.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
                TextField(
                    value = username.toString(),
                    onValueChange = { loginViewModel.onUsernameChanged(it) },
                    modifier = Modifier.padding(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Brown,
                        unfocusedContainerColor = Brown,
                        disabledContainerColor = Gold,
                        focusedIndicatorColor = Gold,
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.width(155.dp)
                ) {
                    Text(
                        text = "Password",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(15.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
                TextField(
                    value = password.toString(),
                    onValueChange = { loginViewModel.onPasswordChanged(it) },
                    modifier = Modifier.padding(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Brown,
                        unfocusedContainerColor = Brown,
                        disabledContainerColor = Gold,
                        focusedIndicatorColor = Gold,
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisibility == true) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(
                            imageVector = loginViewModel.viewIcon(),
                            contentDescription = "Visible",
                            tint = Color.Black,
                            modifier = Modifier.clickable { loginViewModel.togglePasswordVisibility() }
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.navigate("ForYouView") }
            ) {
                Text(
                    text = "Log In",
                )
            }
        }
    }
}