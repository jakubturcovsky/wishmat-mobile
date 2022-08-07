package com.wishmat.android.ui.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wishmat.shared.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    state: SettingsViewModel.State,
    navigator: SettingsScreenNavigator,
    interactor: SettingsScreenInteractor,
) {
    Text(text = "Hi from Settings!")
}
