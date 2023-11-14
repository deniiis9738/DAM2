package com.example.estrella

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.estrella.ui.theme.EstrellaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstrellaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val image = AnimatedImageVector.animatedVectorResource(R.drawable.drawing)
                    var atEnd by remember { mutableStateOf(false) }

                    Image(
                        painter = rememberAnimatedVectorPainter(image, atEnd),
                        contentDescription = "VectorDrawable",
                        modifier = Modifier.clickable {
                            atEnd = !atEnd
                        }
                    )
                }
            }
        }
    }
}