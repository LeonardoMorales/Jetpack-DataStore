package dev.leonardom.jetpackdatastore.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dev.leonardom.jetpackdatastore.Application
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

const val SETTING_PREFERENCES_NAME: String = "settings_preferences"

@Singleton
class SettingsDataStore
@Inject
constructor(
    private val context: Application
){

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        SETTING_PREFERENCES_NAME)

    val settingsPrefsFlow: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val darkTheme = preferences[DARK_THEME_KEY] ?: false
            darkTheme
        }

    suspend fun toggleDarkTheme() {
        context.dataStore.edit { preferences ->
            val current = preferences[DARK_THEME_KEY] ?: false
            preferences[DARK_THEME_KEY] = !current
        }
    }


    companion object {
        val DARK_THEME_KEY = booleanPreferencesKey("dark_theme_key")
    }

}







