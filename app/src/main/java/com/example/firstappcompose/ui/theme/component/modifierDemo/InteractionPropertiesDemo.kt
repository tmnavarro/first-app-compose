package com.example.firstappcompose.ui.theme.component.modifierDemo

import android.widget.Toast
import androidx.annotation.OptIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme
import kotlin.math.roundToInt

@kotlin.OptIn(ExperimentalFoundationApi::class)
@Composable
fun InteractionPropertiesDemo(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green)
                .clickable(
//                    interactionSource = null,
//                    indication = null
                ) {
                    Toast.makeText(context, "Clique realizado", Toast.LENGTH_LONG).show()
                }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green)
                .combinedClickable(
                    onClick = {
                        Toast.makeText(context, "Clique realizado", Toast.LENGTH_LONG).show()
                    },
                    onLongClick = {
                        Toast.makeText(context, "Clique realizado LONGO", Toast.LENGTH_LONG).show()
                    },
                    onDoubleClick = {
                        Toast.makeText(context, "Clique realizado 2 vezes", Toast.LENGTH_LONG).show()
                    }
                )
        )

        var offsetX by remember { mutableFloatStateOf(0f) }
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(offsetX.roundToInt(), 0)
                }
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        offsetX += delta
                    }
                )
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            Toast.makeText(context, "Tapppss", Toast.LENGTH_LONG).show()
                        }
                    )
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun InteractionPropertiesDemoPreview() {
    FirstAppComposeTheme {
        InteractionPropertiesDemo()
    }
}