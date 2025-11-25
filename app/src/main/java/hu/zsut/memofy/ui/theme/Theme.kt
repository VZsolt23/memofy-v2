package hu.zsut.memofy.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun MemofyTheme(
    userTheme: String = "green",
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = remember(userTheme, darkTheme) {
        getMemofyColorScheme(userTheme, darkTheme)
    }

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