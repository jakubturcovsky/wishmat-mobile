package com.wishmat.android.ui

import androidx.lifecycle.SavedStateHandle
import com.wishmat.shared.viewmodel.ViewModel

interface ScreenInteractor<VM : ViewModel> {

    val viewModel: VM
    val savedStateHandle: SavedStateHandle?

}
