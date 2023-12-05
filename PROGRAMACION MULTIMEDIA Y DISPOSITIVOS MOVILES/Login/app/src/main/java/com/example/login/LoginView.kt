package com.example.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.login.ui.theme.ButtonBlue
import com.example.login.ui.theme.EnabledGreen
import com.example.login.ui.theme.PrimaryGreen
import com.example.login.ui.theme.SecondaryGreen

class LoginView {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun login(loginViewModel: LoginViewModel) {
        val email by loginViewModel.email.observeAsState(initial = "")
        val password by loginViewModel.password.observeAsState(initial = "")
        val passwordVisibility by loginViewModel.passwordVisibility.observeAsState(initial = false)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryGreen),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.iescaminas),
                contentDescription = "iescaminas",
                modifier = Modifier.clip(CircleShape)
            )
            TextField(
                value = email,
                onValueChange = { loginViewModel.onEmailChanged(it) },
                enabled = true,
                placeholder = {
                    Text(
                        text = "Email",
                        color = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = PrimaryGreen,
                    textColor = Color.White,
                    focusedIndicatorColor = SecondaryGreen
                ),
            )
            TextField(
                value = password,
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                enabled = true,
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = PrimaryGreen,
                    textColor = Color.White,
                    focusedIndicatorColor = SecondaryGreen
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = loginViewModel.viewIcon()
                    Icon(
                        imageVector = icon,
                        contentDescription = "Visible",
                        tint = Color.White,
                        modifier = Modifier.clickable { loginViewModel.togglePasswordVisibility()}
                    )
                }
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.align(Alignment.End),
            ) {
                Text(
                    text = "¿Has olvidado tu contraseña?",
                    color = ButtonBlue
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor =  loginViewModel.changeColor(SecondaryGreen, EnabledGreen)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Login In",
                    color = ButtonBlue
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(165.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "OR",
                    color = ButtonBlue
                )
                Spacer(modifier = Modifier.width(8.dp))
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(165.dp)
                )
            }
        }
    }
}