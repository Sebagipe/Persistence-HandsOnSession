package com.example.persistence.model

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.preferencesDataStore

private const val PREFERENCES_NAME = "user_preferences"

// Top Level -> wird nur einmal definiert
private val Context.dataStore by preferencesDataStore(PREFERENCES_NAME)

class DataStore(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        val ALWAYS_ON_SCREEN_KEY = booleanPreferencesKey("always_on_screen")
        //TODO 1a: Definiere die PreferenceKey für Dark Theme
    }

    val alwaysOnScreenFlow: Flow<Boolean> = dataStore.data.map { preferences ->
            preferences[ALWAYS_ON_SCREEN_KEY] == true
        }

    suspend fun setAlwaysOnScreen(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[ALWAYS_ON_SCREEN_KEY] = enabled
        }
    }

    //TODO 1b:  Definiere Flow Eigenschaft für DarkTheme, sowie die Funktion zur Einstellung
}