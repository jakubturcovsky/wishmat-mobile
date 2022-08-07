package com.wishmat.android.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.wishmat.shared.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = getViewModel(),
    navigator: HomeScreenNavigator,
) {
    val state by viewModel.state.collectAsState()
    HomeScreen(
        state = state,
        navigator = navigator,
        interactor = HomeScreenInteractor(viewModel),
    )
}
