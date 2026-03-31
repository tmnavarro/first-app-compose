package com.example.firstappcompose.ui.theme.basicDemo

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun BasicDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        val context = LocalContext.current
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Toast.makeText(context, "Btn Clicado", Toast.LENGTH_LONG).show()
            },
            enabled = true,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text= "Clique aqui")
        }



        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = true,
                onCheckedChange = { isCheck ->

                },
                colors = CheckboxDefaults.colors(checkedColor = Color.Green)
            )
            Text("Selecionar?")
        }



        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = LoremIpsum(200).values.joinToString(),
                    color = Color.Gray,
                    fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                    textAlign = TextAlign.Start,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )

                Switch(
                    checked = true,
                    onCheckedChange = { isCheck ->

                    },
                    thumbContent = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    },
                    colors = SwitchDefaults.colors(checkedTrackColor = Color.Green)
                )

                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        Toast.makeText(context, "Btn Clicado", Toast.LENGTH_LONG).show()
                    },
                    enabled = true,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text= "Clique aqui")
                    }
                }
            }
        }

        TextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text("Placeholder")
            },
            supportingText = {
                Text("Explicação...")
            },
            isError = true
        )

        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text("Placeholder")
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun BasicDemoPreview() {
    FirstAppComposeTheme {
        Scaffold { innerPadding ->
            BasicDemo( modifier = Modifier.padding(innerPadding))
        }
    }
}