package hu.zsut.memofy.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class MemofyColorSet(
    val primaryLight: Color,
    val textLight: Color,
    val primaryDark: Color,
    val textDark: Color
)

fun getCurrentSchemeColors(userTheme: String): MemofyColorSet {
    val primaryLight = when (userTheme) {
        "green" -> MemofyGreenLight
        "yellow" -> MemofyYellowLight
        "blue" -> MemofyBlueLight
        "red" -> MemofyRedLight
        "purple" -> MemofyPurpleLight
        else -> MemofyGreenLight
    }

    val textLight = when (userTheme) {
        "green" -> MemofyCustomTextForGreenLight
        "yellow" -> MemofyCustomTextForYellowLight
        "blue" -> MemofyCustomTextForBlueLight
        "red" -> MemofyCustomTextForRedLight
        "purple" -> MemofyCustomTextForPurpleLight
        else -> MemofyCustomTextForGreenLight
    }

    val primaryDark = when (userTheme) {
        "green" -> MemofyGreenDark
        "yellow" -> MemofyYellowDark
        "blue" -> MemofyBlueDark
        "red" -> MemofyRedDark
        "purple" -> MemofyPurpleDark
        else -> MemofyGreenDark
    }

    val textDark = when (userTheme) {
        "green" -> MemofyCustomTextForGreenDark
        "yellow" -> MemofyCustomTextForYellowDark
        "blue" -> MemofyCustomTextForBlueDark
        "red" -> MemofyCustomTextForRedDark
        "purple" -> MemofyCustomTextForPurpleDark
        else -> MemofyCustomTextForGreenDark
    }

    return MemofyColorSet(
        primaryLight = primaryLight,
        textLight = textLight,
        primaryDark = primaryDark,
        textDark = textDark
    )
}

fun getMemofyColorScheme(userTheme: String, darkTheme: Boolean): ColorScheme {
    val colors = getCurrentSchemeColors(userTheme)
    return if (darkTheme) {
        darkMemofyColorScheme(colors.primaryDark, colors.textDark)
    } else {
        lightMemofyColorScheme(colors.primaryLight, colors.textLight)
    }
}