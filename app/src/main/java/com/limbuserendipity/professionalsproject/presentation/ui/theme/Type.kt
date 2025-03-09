package com.limbuserendipity.professionalsproject.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.limbuserendipity.professionalsproject.R

// Set of Material typography styles to start with
// https://developer.android.com/develop/ui/compose/designsystems/material3
val newPeninimMtFont = Font(R.font.new_peninim_mt)

val AppTypography = Typography(
    bodyLarge = Typography().bodyLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    displayLarge = Typography().displayLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    displayMedium = Typography().displayMedium.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    displaySmall = Typography().displaySmall.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Block,
        fontSize = 30.sp
    ),
    headlineMedium = Typography().headlineLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Block,
        fontSize = 34.sp
    ),
    headlineSmall = Typography().headlineSmall.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    titleLarge = Typography().titleLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    titleMedium = Typography().titleMedium.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    titleSmall = Typography().titleSmall.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = SubTextLight,
        fontSize = 16.sp
    ),
    bodyMedium = Typography().bodyMedium.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    bodySmall = Typography().bodySmall.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    labelLarge = Typography().labelLarge.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    labelMedium = Typography().labelMedium.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    ),
    labelSmall = Typography().labelSmall.copy(
        fontFamily = FontFamily(newPeninimMtFont),
        color = Text
    )
)