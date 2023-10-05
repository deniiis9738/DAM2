package com.example.myphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myphotos.ui.theme.MyPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var selectedImages by remember { mutableStateOf<Set<Int>>(emptySet()) }

    val dataItems = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8
    )

    LazyRow(
        content = {
            items(dataItems) { imageResId ->
                val isSelected = imageResId in selectedImages
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(220.dp)
                        .clickable {
                            selectedImages = if (isSelected) {
                                selectedImages - imageResId
                            } else {
                                selectedImages + imageResId
                            }
                        }
                        .alpha(if (isSelected) 0.7f else 1.0f)
                )
            }
        }
    )

    selectedImages.forEach { imageResId ->
        ImageDetail(imageResId = imageResId)
    }
}

@Composable
fun ImageDetail(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .height(800.dp)
            .padding(10.dp)
            .size(400.dp)
    )
}