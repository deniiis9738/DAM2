package com.example.playjuegosdib

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Play() {
    val titles = listOf(
        "Angry Birds",
        "Dragon Fly",
        "Hill Climbing Racing",
        "Radiant Defense",
        "Pocket Soccer",
        "Ninja Jump",
        "Air Control"
    )
    val drawableResources = listOf(
        R.drawable.games_angrybirds,
        R.drawable.games_dragonfly,
        R.drawable.games_hillclimbingracing,
        R.drawable.games_radiantdefense,
        R.drawable.games_pocketsoccer,
        R.drawable.games_ninjump,
        R.drawable.games_aircontrol
    )
    val checkInfoList = getOptions(titles, drawableResources)
    val selectedGames = checkInfoList.filter { it.selected }.map { it.title }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        checkInfoList.forEach { checkInfo -> CheckInfoItem(checkInfo) }
    }
    FloatingActionButton(selectedGames)
}

@Composable
fun CheckInfoItem(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = checkInfo.image),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(shape = RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { isChecked -> checkInfo.onCheckedChange(isChecked) },
        )
        Text(
            text = checkInfo.title,
            Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun getOptions(titles: List<String>, drawableResources: List<Int>): List<CheckInfo> {
    return titles.mapIndexed { index, title ->
        var estadoCheck by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            image = drawableResources[index],
            title = title,
            selected = estadoCheck,
            onCheckedChange = { isChecked -> estadoCheck = isChecked }
        )
    }
}

@Composable
private fun FloatingActionButton(selectedGames: List<String>) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                )
            },
            onClick = {
                if (selectedGames.isNotEmpty()) {
                    val lastIndex = selectedGames.size - 1
                    var message = ""
                    for (i in selectedGames.indices) {
                        message += selectedGames[i]
                        if (i == lastIndex - 1) {
                            message += " y "
                        } else if (i != lastIndex) {
                            message += ", "
                        }
                    }
                    Toast.makeText(context, "Has seleccionado $message", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "No has seleccionado ningún juego", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
    }
}