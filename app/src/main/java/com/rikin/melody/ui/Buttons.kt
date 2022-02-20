package com.rikin.melody.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.theme.ButtonBackground
import com.rikin.melody.ui.theme.ButtonText
import com.rikin.melody.ui.theme.MelodyTheme

data class ButtonStyle(
    val backgroundColor: Color,
    val textColor: Color,
)

@Composable
fun CoolButton(action: () -> Unit) {
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(16.dp))
        .clickable { action() }
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(60.dp)
                .background(
                    color = ButtonBackground,
                    shape = RoundedCornerShape(size = 16.dp)
                )
                .clip(RoundedCornerShape(size = 16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Button", color = ButtonText, style = MaterialTheme.typography.button)
        }
    }
}

@Composable
fun TextButton(action: () -> Unit) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { action() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Text",
            color = ButtonBackground,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview
@Composable
fun CoolButtonPreview() {
    MelodyTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CoolButton(action = {})
        }
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    MelodyTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            TextButton(action = {})
        }
    }
}