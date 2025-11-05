package hu.zsut.memofy.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val MemofyGreen = Color(0xFF24ACA2)
val MemofyYellow = Color(0xFFF6C342)
val MemofyPurple = Color(0xFFAE42f6)
val MemofyRed = Color(0xFFF6424E)
val MemofyBlue = Color(0xFF9CBEEC)
val MemofyCustomText = Color(0xFFFBDDAE)

@Immutable
data class MemofyColors(
    val primary: Color,
    val text: Color,
//    val textSecondary: Color,
    val background: Color
)

val GreenThemeColors = MemofyColors(
    primary = MemofyGreen,
    text = MemofyCustomText,
    background = Color(0xFFE3F2FD)
)

val YellowThemeColors = MemofyColors(
    primary = MemofyYellow,
    text = Color.Black,
    background = Color(0xFFE3F2FD)
)

val BlueThemeColors = MemofyColors(
    primary = MemofyBlue,
    text = Color.Black,
    background = Color(0xFFE3F2FD)
)

val PurpleThemeColors = MemofyColors(
    primary = MemofyPurple,
    text = Color.Black,
    background = Color(0xFFE3F2FD)
)

val RedThemeColors = MemofyColors(
    primary = MemofyRed,
    text = Color.Black,
    background = Color(0xFFE3F2FD)
)
