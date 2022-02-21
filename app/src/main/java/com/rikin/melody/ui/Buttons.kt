package com.rikin.melody.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.theme.ButtonBackground
import com.rikin.melody.ui.theme.ButtonText
import com.rikin.melody.ui.theme.MelodyTheme

private val ButtonWidth = 100.dp
private val ButtonHeight = 60.dp
private val IconButtonSize = 60.dp
private val ButtonShape = RoundedCornerShape(16.dp)

data class ButtonStyle(
    val backgroundColor: Color,
    val textColor: Color,
)

@Composable
fun FilledButton(action: () -> Unit) {
    Box(modifier = Modifier
        .clip(shape = ButtonShape)
        .clickable { action() }
    ) {
        Box(
            modifier = Modifier
                .width(ButtonWidth)
                .height(ButtonHeight)
                .background(
                    color = ButtonBackground,
                    shape = ButtonShape
                )
                .clip(ButtonShape),
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
            .width(ButtonWidth)
            .height(ButtonHeight)
            .clip(ButtonShape)
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

@Composable
fun IconButton(action: () -> Unit) {
    Box(modifier = Modifier.clip(ButtonShape).clickable { action() }) {
        Box(
            modifier = Modifier
                .size(IconButtonSize)
                .background(ButtonBackground, ButtonShape)
                .clip(ButtonShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.Build,
                contentDescription = "",
                tint = ButtonText
            )
        }
    }
}

@Preview
@Composable
fun CoolButtonPreview() {
    MelodyTheme {
        FilledButton(action = {})
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    MelodyTheme {
        TextButton(action = {})
    }
}

@Preview
@Composable
fun IconButtonPreview() {
   MelodyTheme {
       IconButton(action = {})
   }
}