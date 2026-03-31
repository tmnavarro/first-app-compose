package com.example.firstappcompose.ui.theme.component.layoutDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun ConstraintLayoutDemo(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (title, subtitle, boxRed, boxBlue, boxGreen) = createRefs()

        Text(
            text = " Título",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })


        Text(
            text = " Subtile",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(subtitle) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                })

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(subtitle.bottom)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxGreen.bottom)
                    start.linkTo(parent.start)
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ConstraintLayoutDemoPreview() {
    FirstAppComposeTheme {
        ConstraintLayoutDemo()
    }
}