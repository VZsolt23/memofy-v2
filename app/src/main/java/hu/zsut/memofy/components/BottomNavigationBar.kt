package hu.zsut.memofy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BottomNavigationBar(
    currentScreen: String,
    onNavigate: (String) -> Unit
) {
    val navColors: NavigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
        unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
        indicatorColor = Color.White.copy(alpha = 0.15f),
//        indicatorColor =  Color.Transparent,
        disabledIconColor = Color.LightGray.copy(alpha = 0.45f),
        disabledTextColor = Color.LightGray.copy(alpha = 0.45f),
    )

    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        NavigationBarItem(
            selected = currentScreen == "home",
            onClick = { onNavigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Főoldal") },
            label = {
                Text(
                    "Főoldal",
                    fontWeight = if (currentScreen == "home") FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = navColors
        )
        NavigationBarItem(
            selected = currentScreen == "people",
            onClick = { onNavigate("people") },
            icon = { Icon(Icons.Default.Face, contentDescription = "Személyek") },
            label = {
                Text(
                    "Személyek",
                    fontWeight = if (currentScreen == "people") FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = navColors
        )
        NavigationBarItem(
            selected = currentScreen == "settings",
            onClick = { onNavigate("settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Beállítások") },
            label = {
                Text(
                    "Beállítások",
                    fontWeight = if (currentScreen == "settings") FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = navColors,
        )
    }
}