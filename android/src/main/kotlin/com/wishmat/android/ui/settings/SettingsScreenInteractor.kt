package com.wishmat.android.ui.settings

import androidx.lifecycle.SavedStateHandle
import com.wishmat.android.ui.ScreenInteractor
import com.wishmat.shared.viewmodel.HomeViewModel
import com.wishmat.shared.viewmodel.SettingsViewModel

class SettingsScreenInteractor(
    override val viewModel: SettingsViewModel,
    override val savedStateHandle: SavedStateHandle? = null,
) : ScreenInteractor<SettingsViewModel> {

}
