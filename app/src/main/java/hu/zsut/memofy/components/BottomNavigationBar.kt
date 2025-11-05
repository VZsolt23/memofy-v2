package hu.zsut.memofy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import hu.zsut.memofy.ui.theme.MemofyGreen

@Composable
fun BottomNavigationBar(
    currentScreen: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(containerColor = MemofyGreen) {
        NavigationBarItem(
            selected = currentScreen == "home",
            onClick = { onNavigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Főoldal") },
            label = { Text("Főoldal") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFFF9C4),
                selectedTextColor = Color(0xFFFFF9C4),
                unselectedIconColor = Color(0xFFFFF9C4).copy(alpha = 0.6f),
                unselectedTextColor = Color(0xFFFFF9C4).copy(alpha = 0.6f)
            )
        )
        NavigationBarItem(
            selected = currentScreen == "people",
            onClick = { onNavigate("people") },
            icon = { Icon(Icons.Default.Face, contentDescription = "Személyek") },
            label = { Text("Személyek") }
        )
        NavigationBarItem(
            selected = currentScreen == "settings",
            onClick = { onNavigate("settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Beállítások") },
            label = { Text("Beállítások") }
        )
    }
}