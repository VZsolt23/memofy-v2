package hu.zsut.memofy.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import hu.zsut.memofy.layout.MainLayout
import hu.zsut.memofy.views.HomeContent

@Preview
@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("home") }

    MainLayout(currentScreen = currentScreen, onNavigate = { screen ->
        currentScreen = screen
    }) {
        when (currentScreen) {
            "home" -> HomeContent()
//            "people" -> PeopleContent()
//            "settings" -> SettingsContent()
        }
    }
}
