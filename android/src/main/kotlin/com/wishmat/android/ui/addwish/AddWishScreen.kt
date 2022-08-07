package com.wishmat.android.ui.addwish

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wishmat.android.ui.ScreenNavigator
import com.wishmat.android.ui.home.HomeScreenInteractor
import com.wishmat.android.ui.home.HomeScreenNavigator
import com.wishmat.shared.viewmodel.AddWishViewModel
import com.wishmat.shared.viewmodel.HomeViewModel

@Composable
fun AddWishScreen(
    state: AddWishViewModel.State,
    navigator: AddWishScreenNavigator,
    interactor: AddWishScreenInteractor,
) {
    Text(text = "Your wish is my command!")
}
