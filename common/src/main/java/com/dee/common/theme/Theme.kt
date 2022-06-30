package com.dee.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dee.common.R

private val DarkColorPalette = darkColors(
    primary = black,
    primaryVariant = black,
    secondary = Teal200,
    background = black
)

private val LightColorPalette = lightColors(
    primary = black,
    primaryVariant = black,
    secondary = Teal200,
    background = black

    /* Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val robotoRegularFontFamily = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_regular, weight = FontWeight.Bold),
    Font(R.font.roboto_regular, weight = FontWeight.Medium),
    Font(R.font.roboto_regular, weight = FontWeight.Light),
    Font(R.font.roboto_regular, weight = FontWeight.Normal, style = FontStyle.Italic)
)

private val appTypoGraphy = Typography(
    body1 = TextStyle(
        fontFamily = robotoRegularFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = robotoRegularFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontFamily = robotoRegularFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = robotoRegularFontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    )
)

@Composable
fun NetflixTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = appTypoGraphy,
        shapes = Shapes,
        content = content,
    )
}