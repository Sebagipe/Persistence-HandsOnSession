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
        //TODO 2a: Rufe Methode auf, zur Veränderung des gespeicherten Wertes im DataStore für alwaysOnScreen
        // Wichtig!!! suspend Funktionen können nicht in der main-Thread ausgeführt werden (und sollen natürlich auch nicht)
    }

    // TODO 2b: Definiere die Notwendige Funktionen zur Zugriff auf dark Theme über den viewModel
    fun isDarkTheme()
    fun setDarkTheme(enabled: Boolean) {}

}