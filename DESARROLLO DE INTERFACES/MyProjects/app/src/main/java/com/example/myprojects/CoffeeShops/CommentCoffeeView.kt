package com.example.coffeshops

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprojects.ui.theme.Pink100
import com.example.myprojects.ui.theme.alviaregular
import kotlinx.coroutines.launch

@Composable
fun CommentCoffeeView(title: String) {
    val rvState = rememberLazyStaggeredGridState()
    val comments = getCommentCoffeeShops()
    val showButton by remember {
        derivedStateOf {
            rvState.firstVisibleItemScrollOffset > 0
        }
    }
    val coroutineScope = rememberCoroutineScope()

    Column {
        Text(
            text = title,
            fontSize = 38.sp,
            fontFamily = alviaregular,
            modifier = Modifier.padding(10.dp)
                .align(Alignment.CenterHorizontally),
        )
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.weight(2.5f),
            content = {
                items(comments) { comment ->
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(Pink100)
                    ){
                        Text(
                            text = comment,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        )
        if (showButton) {
            Button(
                onClick = { coroutineScope.launch { rvState.animateScrollToItem(0) } },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Add a new comment")
            }
        }
    }
}

@Composable
fun getCommentCoffeeShops(): List<String> {
    return listOf(
        "El aroma del café recién molido en esta cafetería es irresistible.",
        "Me encanta el ambiente acogedor de este lugar. Perfecto para una tarde de café.",
        "El latte art en este café es una verdadera obra de arte.",
        "Este lugar es mi refugio matutino. El café es excepcional.",
        "La atención al cliente aquí es excepcional. Siempre vuelvo por más café.",
        "Café delicioso en una ubicación conveniente. No puedo pedir más.",
        "Una joya oculta para los amantes del café. Siempre sorprenden con nuevos sabores.",
        "La decoración de esta cafetería es tan acogedora. Me siento como en casa.",
        "El café es fuerte y delicioso, justo como me gusta.",
        "Un rincón perfecto para relajarse con un buen libro y una taza de café.",
        "No puedo resistirme a los pasteles frescos que sirven aquí.",
        "Siempre me siento inspirado cuando vengo a esta cafetería.",
        "Un lugar maravilloso para una cita. El café y la conversación fluyen.",
        "La selección de cafés de esta cafetería es impresionante. Siempre encuentro algo nuevo para probar.",
        "Este es mi lugar de trabajo remoto favorito. El café y el ambiente son ideales para la productividad."
    )
}