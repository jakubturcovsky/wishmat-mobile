package com.wishmat.android.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wishmat.android.ui.theme.Dimensions
import com.wishmat.shared.viewmodel.TextInput

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    title: String,
    textInput: TextInput,
    onValueChange: (String) -> Unit,
) {
    TextInputField(
        modifier = modifier,
        title = title,
        text = textInput.value,
        placeholder = textInput.placeholder,
        error = textInput.error,
        onValueChange = onValueChange,
    )
}

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    placeholder: String,
    error: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = Dimensions.Padding.half),
            text = title,
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(placeholder)
            },
            value = text,
            onValueChange = onValueChange,
            isError = error.isNotEmpty(),
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                modifier = Modifier.padding(start = Dimensions.Padding.default),
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}
