package com.wishmat.android.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wishmat.shared.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    Text(text = "Hi mom!")
}
