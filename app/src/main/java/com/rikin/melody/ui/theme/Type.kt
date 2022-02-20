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

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = recursiveFontFamily,
    body1 = TextStyle(
        fontFamily = recursiveFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = recursiveFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)