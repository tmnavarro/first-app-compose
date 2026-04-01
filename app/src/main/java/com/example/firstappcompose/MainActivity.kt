package com.example.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme
import com.example.firstappcompose.ui.theme.Typography
import com.example.firstappcompose.ui.theme.component.HelloContent
import com.example.firstappcompose.ui.theme.component.customComponents.ChooseMyFavoriteHero
import com.example.firstappcompose.ui.theme.component.modifierDemo.InteractionPropertiesDemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HelloContent(modifier = Modifier.padding(innerPadding))
//                    InteractionPropertiesDemo(modifier = Modifier.padding(innerPadding))
                    ChooseMyFavoriteHero(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
