package com.example.persistence.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.persistence.viewmodels.SettingsViewModel


@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = viewModel<SettingsViewModel>(),
) {
    val alwaysOn by viewModel.isAlwaysOnDisplay().collectAsState(false)
    val darkTheme by  // TODO 3
    SettingsScreen(modifier, alwaysOn, darkTheme, onAlwaysOnChange = {
        viewModel.setAlwaysOnDisplay(!alwaysOn)
    }, onDarkThemeChange = {
        viewModel.setDarkTheme(!darkTheme)
    })
}

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    isAlwaysOnScreen: Boolean,
    darkThemeEnabled: Boolean,
    onAlwaysOnChange: (Boolean) -> Unit,
    onDarkThemeChange: (Boolean) -> Unit,
) {

    Column(modifier = modifier) {
        SettingsItem(
            text = "Display Always On",
            isChecked = isAlwaysOnScreen,
            onCheckedChange = onAlwaysOnChange
        )
        SettingsItem(
            text = "Dark Theme", isChecked = darkThemeEnabled, onCheckedChange = onDarkThemeChange
        )
    }
}

@Composable
@Preview
fun SettingsScreenPreview() {
    SettingsScreen(
        isAlwaysOnScreen = true,
        darkThemeEnabled = false,
        onAlwaysOnChange = {},
        onDarkThemeChange = {})
}


@Composable
fun SettingsItem(
    text: String,
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier.padding(10.dp), horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = text, fontSize = 20.sp, modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
        )
    }
}

@Preview
@Composable
fun SettingsItemPreview() {
    SettingsItem(text = "Test", isChecked = false, onCheckedChange = {})
}
