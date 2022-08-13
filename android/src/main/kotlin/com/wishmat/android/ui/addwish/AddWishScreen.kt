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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import com.wishmat.android.ui.common.TextInputField
import com.wishmat.android.ui.common.TextInputFieldImeAction
import com.wishmat.android.ui.theme.Dimensions
import com.wishmat.shared.viewmodel.addwish.AddWishViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AddWishScreen(viewModel: AddWishViewModel = getViewModel()) {
    val state = viewModel.state.collectAsState()

    val name by viewModel.name.collectAsState()
    val description by viewModel.description.collectAsState()
    val url by viewModel.url.collectAsState()

    val focusedError by viewModel.focusedError.collectAsState()

    val localFocusManager = LocalFocusManager.current
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
                requestFocus = focusedError == name,
                onValueChange = viewModel::onNameChanged,
                onFocusRequested = viewModel::onFocusRequested,
                singleLine = true,
                imeAction = TextInputFieldImeAction.Next(focusManager = localFocusManager),
            )

            TextInputField(
                modifier = Modifier.padding(top = Dimensions.Padding.default),
                title = description.title,
                textInput = description,
                requestFocus = focusedError == description,
                onValueChange = viewModel::onDescriptionChanged,
                onFocusRequested = viewModel::onFocusRequested,
                imeAction = TextInputFieldImeAction.Next(focusManager = localFocusManager),
            )

            TextInputField(
                modifier = Modifier.padding(top = Dimensions.Padding.default),
                title = url.title,
                textInput = url,
                requestFocus = focusedError == url,
                onValueChange = viewModel::onUrlChanged,
                onFocusRequested = viewModel::onFocusRequested,
                singleLine = true,
                keyboardType = KeyboardType.Uri,
                imeAction = TextInputFieldImeAction.Done(action = viewModel::createWish),
            )

            Button(
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = Dimensions.Padding.default),
                onClick = viewModel::createWish
            ) {
                Text(text = "Create")
            }
        }
    }
}
