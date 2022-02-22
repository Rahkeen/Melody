package com.rikin.melody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.FilledButton
import com.rikin.melody.ui.IconButton
import com.rikin.melody.ui.SelectButton
import com.rikin.melody.ui.TextButton
import com.rikin.melody.ui.theme.MelodyTheme

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
                        FilledButton(action = {})
                        TextButton(action = {})
                        IconButton(action = {})
                        SelectButton(action = {})
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