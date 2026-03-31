package com.example.firstappcompose.ui.theme.component.modifierDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun LayoutPropertiesDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .height(100.dp)
                .fillMaxHeight(0.5f)
                .background(Color.Red)
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = (-100).dp, y = 25.dp)
                .background(Color.Blue)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .aspectRatio(16f / 9f)
                .background(Color.Magenta)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Magenta)
            )
            Box(
                modifier = Modifier
                    .weight(5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutPropertiesDemoPreview(modifier: Modifier = Modifier) {
    FirstAppComposeTheme {
        LayoutPropertiesDemo()
    }
}