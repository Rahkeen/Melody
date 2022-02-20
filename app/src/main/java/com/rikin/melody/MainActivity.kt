package com.rikin.melody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.CoolButton
import com.rikin.melody.ui.TextButton
import com.rikin.melody.ui.theme.MelodyTheme
import com.rikin.melody.ui.theme.Playful

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MelodyTheme {
                // A surface container using the 'background' color from the theme
                Row {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5F),
                        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Default", style = MaterialTheme.typography.h5)
                        CoolButton(action = {})
                        TextButton(action = {})
                    }

                    CompositionLocalProvider(LocalIndication provides Playful()) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.5F),
                            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("Custom", style = MaterialTheme.typography.h5)
                            CoolButton(action = {})
                            TextButton(action = {})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MelodyTheme {
        Greeting("Android")
    }
}