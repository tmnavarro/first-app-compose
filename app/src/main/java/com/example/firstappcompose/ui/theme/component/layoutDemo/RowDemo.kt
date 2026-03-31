package com.example.firstappcompose.ui.theme.component.layoutDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
fun RowDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Olá meu texto")
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .padding(16.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .padding(16.dp)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .padding(16.dp)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RowDemoPreview() {
    FirstAppComposeTheme {
        Scaffold { innerPadding ->
            RowDemo(modifier = Modifier.padding(innerPadding))
        }
    }
}