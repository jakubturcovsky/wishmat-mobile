package com.wishmat.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightThemeColors = lightColors(
    // primary = Colors.Green,
    // primaryVariant = Colors.DarkGreen,
    // secondary = Colors.Brown,
    // secondaryVariant = Colors.DarkBrown,
    // background = Color.White,
    // onBackground = Color.Black,
    // surface = Color.White,
    // onSurface = Color.Black,
    // error = Colors.Error,
    // onPrimary = Color.White,
    // onSecondary = Color.Black,
    // onError = Color.White,
)

private val DarkThemeColors = lightColors(
    // primary = Colors.Green,
    // primaryVariant = Colors.DarkGreen,
    // secondary = Colors.Brown,
    // secondaryVariant = Colors.DarkBrown,
    // background = Color.White,
    // onBackground = Color.Black,
    // surface = Color.White,
    // onSurface = Color.Black,
    // error = Colors.Error,
    // onPrimary = Color.White,
    // onSecondary = Color.Black,
    // onError = Color.White,
)

private val fontFamily = FontFamily.Default

private val defaultTypography = Typography()

private val typography = Typography(
    h1 = defaultTypography.h1.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    h2 = defaultTypography.h2.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    h3 = defaultTypography.h3.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    h4 = defaultTypography.h4.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    h5 = defaultTypography.h5.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
    ),
    h6 = defaultTypography.h6.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    body1 = defaultTypography.body1.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    body2 = defaultTypography.body2.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    subtitle1 = defaultTypography.subtitle1.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
    ),
    subtitle2 = defaultTypography.subtitle2.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    caption = defaultTypography.caption.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    button = defaultTypography.button.copy(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    defaultFontFamily = fontFamily,
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) LightThemeColors else DarkThemeColors,
        typography = typography,
        content = content,
    )
}
