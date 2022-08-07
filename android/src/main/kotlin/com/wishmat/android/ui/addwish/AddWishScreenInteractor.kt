package com.wishmat.android.ui.addwish

import androidx.lifecycle.SavedStateHandle
import com.wishmat.android.ui.ScreenInteractor
import com.wishmat.shared.viewmodel.AddWishViewModel
import com.wishmat.shared.viewmodel.HomeViewModel

class AddWishScreenInteractor(
    override val viewModel: AddWishViewModel,
    override val savedStateHandle: SavedStateHandle? = null,
) : ScreenInteractor<AddWishViewModel> {

}
