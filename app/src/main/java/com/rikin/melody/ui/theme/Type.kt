package com.rikin.melody.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rikin.melody.R

val recursiveFontFamily = FontFamily(
    Font(R.font.recursive_regular, FontWeight.Normal)
)

val quicksandFontFamily = FontFamily(
    Font(R.font.quicksand_regular, FontWeight.Normal),
    Font(R.font.quicksand_medium, FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = recursiveFontFamily,
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)