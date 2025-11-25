package hu.zsut.memofy.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

object ThemePreference {
    private val THEME_KEY = stringPreferencesKey("memofy_user_theme")

    fun getUserTheme(context: Context): Flow<String> =
        context.dataStore.data.map { prefs ->
            prefs[THEME_KEY] ?: "green"
        }

    suspend fun saveUserTheme(context: Context, theme: String) {
        context.dataStore.edit { prefs ->
            prefs[THEME_KEY] = theme
        }
    }
}