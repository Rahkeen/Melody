package com.rikin.melody.ui

import ClipShape
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.theme.*

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
              color = ButtonBackgroundBlue,
              shape = ButtonShape
          )
          .clip(ButtonShape),
      contentAlignment = Alignment.Center
    ) {
      Text(text = "Button", color = ButtonTextBlue, style = MaterialTheme.typography.button)
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
      color = ButtonTextGreen,
      style = MaterialTheme.typography.button
    )
  }
}

@Composable
fun IconButton(action: () -> Unit) {
  Box(modifier = Modifier
      .clip(ButtonShape)
      .clickable { action() }) {
    Box(
      modifier = Modifier
          .size(IconButtonSize)
          .background(ButtonBackgroundPurple, ButtonShape)
          .clip(ButtonShape),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        modifier = Modifier.size(16.dp),
        imageVector = Icons.Filled.Build,
        contentDescription = "",
        tint = ButtonTextPurple
      )
    }
  }
}

@Composable
fun SelectButton(action: () -> Unit) {
  var selected by remember { mutableStateOf(false) }
  val transition = updateTransition(targetState = selected, label = "")
  val progress by transition.animateFloat(transitionSpec = { tween(1000) }, label = "") { state ->
    if (state) 1F else 0F
  }

    Box(modifier = Modifier.clickable { selected = !selected }) {
        Box(modifier = Modifier.clip(shape = ButtonShape)) {
            Box(
                modifier = Modifier
                    .width(ButtonWidth)
                    .height(ButtonHeight)
                    .background(
                        color = ButtonBackgroundOrange,
                        shape = ButtonShape
                    )
                    .clip(ButtonShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Select", color = ButtonTextOrange, style = MaterialTheme.typography.button)
            }
        }
        Box(
            modifier = Modifier
                .width(ButtonWidth)
                .height(ButtonHeight)
                .clip(ClipShape(progress = progress))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ButtonTextOrange, ButtonShape)
                    .clip(ButtonShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Select",
                    color = ButtonBackgroundOrange,
                    style = MaterialTheme.typography.button
                )
            }
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

@Preview
@Composable
fun SelectedButtonPreview() {
  MelodyTheme {
    SelectButton(action = {})
  }
}