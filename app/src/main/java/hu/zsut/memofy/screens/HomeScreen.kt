package hu.zsut.memofy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import hu.zsut.memofy.data.ThemePreference
import hu.zsut.memofy.ui.theme.MemofyBlue
import hu.zsut.memofy.ui.theme.MemofyGreen
import hu.zsut.memofy.ui.theme.MemofyPurple
import hu.zsut.memofy.ui.theme.MemofyRed
import hu.zsut.memofy.ui.theme.MemofyYellow
import kotlinx.coroutines.launch
import java.util.Locale

fun themeToColor(theme: String): Color {
    return when (theme.lowercase(Locale.ROOT)) {
        "green" -> MemofyGreen
        "yellow" -> MemofyYellow
        "blue" -> MemofyBlue
        "red" -> MemofyRed
        "purple" -> MemofyPurple
        else -> Color.Gray
    }
}

@Composable
fun HomeContent() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val themes = listOf("green", "yellow", "blue", "red", "purple")

    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(themes) { theme ->
                Button(
                    onClick = {
                        scope.launch {
                            ThemePreference.saveUserTheme(context, theme)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = themeToColor(theme),
                        contentColor = Color.White
                    )
                ) {
                    Text(theme.replaceFirstChar { it.titlecase(Locale.ROOT) })
                }
            }
        }
    }
}