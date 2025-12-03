package hu.zsut.memofy.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import hu.zsut.memofy.ui.layout.MainLayout
import hu.zsut.memofy.ui.persons.add.AddPersonScreen
import hu.zsut.memofy.ui.home.HomeView
import hu.zsut.memofy.ui.persons.list.PersonListScreen

@Preview
@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("home") }

    MainLayout(currentScreen = currentScreen, onNavigate = { screen ->
        currentScreen = screen
    }) {
        when (currentScreen) {
            "home" -> HomeView()
            "people" -> PersonListScreen()
            "settings" -> AddPersonScreen()
//            "settings" -> SettingsContent()
        }
    }
}
