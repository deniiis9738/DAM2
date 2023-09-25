package com.example.playjuegosdib

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playjuegosdib.ui.theme.Lime800
import com.example.playjuegosdib.ui.theme.Pink50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuNewPlayer() {
    val pesoH = 2f
    val pesoV = 1f

    var TextField1 by remember { mutableStateOf("") }
    var TextField2 by remember { mutableStateOf("") }
    var TextField3 by remember { mutableStateOf("") }
    var TextField5 by remember { mutableStateOf("") }

    var isError1 by rememberSaveable { mutableStateOf(false) }
    var isError2 by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(text = if (isError1) "Error: Obligatorio" else "*Obligatorio",
                fontSize = 13.sp,
                color = if (isError1) Color.Red else Color.Black)
            Spacer(modifier = Modifier.width(85.dp))
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Account",
                Modifier
                    .size(60.dp)
                    .weight(pesoV)
            )
            TextField(value = TextField1, onValueChange = {TextField1 = it},
                label = { Text(text = ("Nombre"),
                    Modifier.weight(pesoH))},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Pink50,
                    focusedIndicatorColor = Lime800
                ),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 20.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Spacer(
                modifier = Modifier
                    .size(60.dp)
                    .weight(pesoV))
            TextField(value = TextField2, onValueChange = {TextField2 = it},
                label = { Text(text = ("Apellidos"),
                    Modifier.weight(pesoH))},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Pink50,
                    focusedIndicatorColor = Lime800
                ),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 20.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }
        Row {
            Text(text = if (isError2) "Error: Obligatorio" else "*Obligatorio",
                fontSize = 13.sp,
                color = if (isError2) Color.Red else Color.Black)
            Spacer(modifier = Modifier.width(85.dp))
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
            Spacer(
                modifier = Modifier
                    .size(60.dp)
                    .weight(pesoV))
            TextField(value = TextField3, onValueChange = {TextField3 = it},
                label = { Text(text = ("Nickname"),
                    Modifier.weight(pesoH))},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Pink50,
                    focusedIndicatorColor = Lime800
                ),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 20.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Spacer(
                modifier = Modifier
                    .size(60.dp)
                    .weight(pesoV))
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Android",
                Modifier
                    .size(120.dp)
                    .weight(pesoV)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Lime800
                )) {
                Text(
                    text = stringResource(id = R.string.change),
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "Camera",
                Modifier
                    .size(60.dp)
                    .weight(pesoV)
            )
            TextField(value = "Teléfono", onValueChange = {},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Pink50,
                    focusedIndicatorColor = Lime800
                ),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 20.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "Email",
                Modifier
                    .size(60.dp)
                    .weight(pesoV)
            )
            TextField(value = TextField5, onValueChange = {TextField5 = it},
                label = { Text(text = ("Email"),
                    Modifier.weight(pesoH))},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Pink50,
                    focusedIndicatorColor = Lime800
                ),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 20.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = {
            val isTextField1Empty = TextField1.isBlank()
            val isTextField3Empty = TextField3.isBlank()

            isError1 = isTextField1Empty
            isError2 = isTextField3Empty},
            modifier = Modifier.width(150.dp)) {
            Text(
                text = stringResource(id = R.string.new_player),
                textAlign = TextAlign.Center,
            )
        }
    }
}