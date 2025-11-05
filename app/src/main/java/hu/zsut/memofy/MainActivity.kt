package hu.zsut.memofy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import hu.zsut.memofy.data.ThemePreference
import hu.zsut.memofy.layout.MainLayout
import hu.zsut.memofy.screens.HomeContent
import hu.zsut.memofy.ui.theme.MemofyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current
    val userTheme by ThemePreference.getUserTheme(context)
        .collectAsState(initial = null)

    if (userTheme != null) {
        MemofyTheme(userTheme = userTheme!!) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainScreen()
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
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