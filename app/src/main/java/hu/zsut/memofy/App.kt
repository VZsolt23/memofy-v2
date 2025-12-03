package hu.zsut.memofy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import hu.zsut.memofy.data.ThemePreference
import hu.zsut.memofy.ui.MainScreen
import hu.zsut.memofy.ui.theme.MemofyCustomTextForGreenLight
import hu.zsut.memofy.ui.theme.MemofyGreenLight
import hu.zsut.memofy.ui.theme.MemofyTheme

@Preview
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
                .background(MemofyGreenLight),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MemofyCustomTextForGreenLight)
        }
    }
}