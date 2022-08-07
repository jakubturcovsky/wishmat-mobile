package com.wishmat.android.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.wishmat.shared.viewmodel.SettingsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SettingsRoute(
    viewModel: SettingsViewModel = getViewModel(),
    navigator: SettingsScreenNavigator,
) {
    val state by viewModel.state.collectAsState()
    SettingsScreen(
        state = state,
        navigator = navigator,
        interactor = SettingsScreenInteractor(viewModel),
    )
}
