package hu.zsut.memofy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.zsut.memofy.layout.MainLayout
import hu.zsut.memofy.screens.HomeContent
import hu.zsut.memofy.ui.theme.MemofyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemofyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

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