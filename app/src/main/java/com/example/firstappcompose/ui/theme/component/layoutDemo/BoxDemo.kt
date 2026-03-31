package com.example.firstappcompose.ui.theme.component.layoutDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "Olá meu texto")
        Column(
            Modifier.align(Alignment.TopEnd)
                .fillMaxHeight()
                .background(Color.Gray),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(16.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(16.dp)
                    .background(Color.Yellow)
            )
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(16.dp)
                    .background(Color.Blue)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview() {
    FirstAppComposeTheme {
        Scaffold { innerPadding ->
            BoxDemo(modifier = Modifier.padding(innerPadding))
        }
    }
}