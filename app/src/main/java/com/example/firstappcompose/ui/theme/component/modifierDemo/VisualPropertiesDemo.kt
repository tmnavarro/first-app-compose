package com.example.firstappcompose.ui.theme.component.modifierDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun VisualPropertiesDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
//                .background(color = Color(
//                    color = 0xFF000000
//                ))
//                .background(
//                    brush = Brush.linearGradient(
//                        listOf(Color.Yellow,
//                        Color.Green,
//                        Color.Blue)
//                    )
//                )
                .background(
                    color = Color(
                        red = 155,
                        green = 122,
                        blue = 123,
                        alpha = 150
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(
                    width = 1.dp,
                    color =Color.Black,
                    shape = CircleShape
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(50.dp)
                )
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer {
                    val rotateZ = 15f

                    this.rotationZ = rotateZ
                    rotationX = 15f
                }
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VisualPropertiesDemoPreview(modifier: Modifier = Modifier) {
    FirstAppComposeTheme {
        VisualPropertiesDemo()
    }
}