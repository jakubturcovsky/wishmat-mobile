package com.wishmat.android.ui.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wishmat.shared.viewmodel.SettingsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = getViewModel()) {
    Text(text = "Hi from Settings!")
}
