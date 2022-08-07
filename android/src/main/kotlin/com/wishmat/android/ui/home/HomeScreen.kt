package com.wishmat.android.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wishmat.shared.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    state: HomeViewModel.State,
    navigator: HomeScreenNavigator,
    interactor: HomeScreenInteractor,
) {
    Text(text = "Hi mom!")
}
