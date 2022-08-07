package com.wishmat.android.ui.home

import androidx.lifecycle.SavedStateHandle
import com.wishmat.android.ui.ScreenInteractor
import com.wishmat.shared.viewmodel.HomeViewModel

class HomeScreenInteractor(
    override val viewModel: HomeViewModel,
    override val savedStateHandle: SavedStateHandle? = null,
) : ScreenInteractor<HomeViewModel> {


}
