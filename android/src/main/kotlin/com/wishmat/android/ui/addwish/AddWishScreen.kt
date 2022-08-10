package com.wishmat.android.ui.addwish

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.wishmat.android.ui.common.TextInputField
import com.wishmat.android.ui.theme.Dimensions
import com.wishmat.shared.viewmodel.addwish.AddWishViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AddWishScreen(viewModel: AddWishViewModel = getViewModel()) {
    val name by viewModel.name.collectAsState()
    val description by viewModel.description.collectAsState()
    val url by viewModel.url.collectAsState()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .padding(Dimensions.Padding.default)
        ) {
            TextInputField(
                title = name.title,
                textInput = name,
                onValueChange = viewModel::onNameChanged,
            )

            TextInputField(
                modifier = Modifier.padding(top = Dimensions.Padding.default),
                title = description.title,
                textInput = description,
                onValueChange = viewModel::onDescriptionChanged,
            )

            TextInputField(
                modifier = Modifier.padding(top = Dimensions.Padding.default),
                title = url.title,
                textInput = url,
                onValueChange = viewModel::onUrlChanged,
            )

            Button(
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = Dimensions.Padding.default),
                onClick = { viewModel.createWish() }
            ) {
                Text(text = "Create")
            }
        }
    }
}
