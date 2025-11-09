package hu.zsut.memofy.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// --- Light mode paletta dinamikusan a user theme alapján ---
fun lightMemofyColorScheme(primaryColor: Color, primaryTextColor: Color) = lightColorScheme(
    primary = primaryColor,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = LightBackground,
    surface = LightBackground,
    onPrimary = primaryTextColor,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F)
)

// --- Dark mode paletta dinamikusan a user theme alapján ---
fun darkMemofyColorScheme(primaryColor: Color, primaryTextColor: Color) = darkColorScheme(
    primary = primaryColor,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = primaryTextColor,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5)
)
