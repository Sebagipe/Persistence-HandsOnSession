package com.example.persistence.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.persistence.model.DataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.getValue

class SettingsViewModel(
    app: Application
) : AndroidViewModel(app)  {

    private val dataStore by lazy { DataStore(app.applicationContext) }

    fun isAlwaysOnDisplay() = dataStore.alwaysOnScreenFlow

    fun setAlwaysOnDisplay (enabled : Boolean)  {
        viewModelScope.launch (Dispatchers.IO) {
            dataStore.setAlwaysOnScreen(enabled)
        }
    }

    fun isDarkTheme() = dataStore.darkThemeFlow

    fun setDarkTheme(enabled: Boolean) {
        viewModelScope.launch (Dispatchers.IO) {
            dataStore.setDarkTheme(enabled)
        }
    }

}