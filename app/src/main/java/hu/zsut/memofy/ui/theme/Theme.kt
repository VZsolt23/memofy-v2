package hu.zsut.memofy.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = MemofyGreen,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// todo: ha tényleg szükségesek akkor áthelyezni innen
val DarkBackground = Color(0xFF121212)
val LightBackground = Color(0xFFFFFBFE)

// --- Light mode paletta dinamikusan a user theme alapján ---
private fun lightMemofyColorScheme(primaryColor: Color) = lightColorScheme(
    primary = primaryColor,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = LightBackground,
    surface = LightBackground,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F)
)

// --- Dark mode paletta dinamikusan a user theme alapján ---
private fun darkMemofyColorScheme(primaryColor: Color) = darkColorScheme(
    primary = primaryColor,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5)
)

@Composable
fun MemofyTheme(
    userTheme: String = "green",
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // User által választott szín
    val primaryColor = when (userTheme) {
        "green" -> MemofyGreen
        "yellow" -> MemofyYellow
        "blue" -> MemofyBlue
        "red" -> MemofyRed
        "purple" -> MemofyPurple
        else -> MemofyGreen
    }

    val colorScheme = if (darkTheme) darkMemofyColorScheme(primaryColor)
    else lightMemofyColorScheme(primaryColor)

    val view = LocalView.current
    if (!view.isInEditMode) {
        LaunchedEffect(userTheme, darkTheme) {
            val window = (view.context as Activity).window
            val color = colorScheme.primary.toArgb()

            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.isNavigationBarContrastEnforced = false

            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = !darkTheme
            controller.isAppearanceLightNavigationBars = !darkTheme

            window.statusBarColor = color
            window.navigationBarColor = color

            // Status bar ikonok sötétek legyenek világos háttérnél:
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}