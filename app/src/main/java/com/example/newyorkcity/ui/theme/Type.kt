package com.example.newyorkcity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newyorkcity.R

// Set of Material typography styles to start with
val libreBaserville = FontFamily(
    Font(R.font.libre_baskerville_regular),
    Font(R.font.libre_baskerville_bold),
    Font(R.font.libre_baskerville_italic)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = libreBaserville,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = libreBaserville,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = libreBaserville,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)