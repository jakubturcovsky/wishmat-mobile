package com.wishmat.android.ui.addwish

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.wishmat.android.ui.ScreenNavigator
import com.wishmat.android.ui.home.HomeScreenInteractor
import com.wishmat.android.ui.home.HomeScreenNavigator
import com.wishmat.shared.viewmodel.AddWishViewModel
import com.wishmat.shared.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AddWishRoute(
    viewModel: AddWishViewModel = getViewModel(),
    navigator: AddWishScreenNavigator,
) {
    val state by viewModel.state.collectAsState()
    AddWishScreen(
        state = state,
        navigator = navigator,
        interactor = AddWishScreenInteractor(viewModel),
    )
}
