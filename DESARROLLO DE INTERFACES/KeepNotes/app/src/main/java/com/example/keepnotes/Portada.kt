package com.example.keepnotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepnotes.ui.theme.LightYellow

@Composable
fun Portada() {
    val lazyListState = rememberLazyListState()
    var scrolled = 0f
    var previousOffset = 0

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .graphicsLayer {
                                scrolled += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                translationY = scrolled * 0.5f
                                previousOffset = lazyListState.firstVisibleItemScrollOffset
                            }
                    )
                }
                val comments = getComments()
                items(comments.size) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(LightYellow)
                    ) {
                        Text(
                            text = comments[index],
                            modifier = Modifier
                                .padding(10.dp),
                        )
                    }
                }
            }
        )
    }
}

fun getComments(): List<String> {
    return listOf(
        "Bajo el cielo estrellado, el susurro del viento acariciaba suavemente las hojas de los árboles, creando una sinfonía nocturna que envolvía la tranquila aldea.",
        "Con cada amanecer, el sol pintaba el cielo con tonos cálidos, despertando a la ciudad de su sueño y llenándola de una nueva oportunidad.",
        "Entre risas y cuentos compartidos alrededor de la fogata, la familia forjaba recuerdos que perdurarían en el corazón mucho más allá de la noche.",
        "En la playa desierta, las olas jugueteaban con la arena dorada mientras el sol se sumergía lentamente en el horizonte, tiñendo el cielo de tonos anaranjados y rosados.",
        "La biblioteca, repleta de libros antiguos y secretos, era un refugio donde las mentes curiosas exploraban mundos desconocidos a través de las páginas impresas.",
        "En el rincón más alejado del jardín, una flor solitaria desplegaba sus pétalos, desafiando la adversidad y recordando que la belleza puede surgir incluso en los lugares más inesperados.",
        "En la calle bulliciosa, el anciano músico tocaba su viejo violín con destreza, regalando melodías que evocaban nostalgias y despertaban emociones en quienes lo escuchaban.",
        "El viajero solitario caminaba por senderos desconocidos, llevando consigo la mochila cargada de sueños y la certeza de que cada paso lo acercaba a un destino inexplorado.",
        "La lluvia caía suavemente, transformando la ciudad en un lienzo brillante y reluciente, mientras la gente buscaba refugio bajo paraguas coloridos.",
        "En la cocina, el aroma de especias y hierbas llenaba el aire mientras el chef preparaba con pasión un festín que deleitaría los paladares más exigentes.",
        )
}