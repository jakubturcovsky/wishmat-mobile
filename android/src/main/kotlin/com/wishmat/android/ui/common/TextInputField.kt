package com.wishmat.android.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.wishmat.android.ui.theme.Dimensions
import com.wishmat.shared.viewmodel.TextInput

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    title: String,
    textInput: TextInput,
    onFocusRequested: () -> Unit = {},
    requestFocus: Boolean = false,
    capitalization: KeyboardCapitalization? = null,
    imeAction: TextInputFieldImeAction? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onValueChange: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(requestFocus) {
        if (requestFocus) {
            focusRequester.requestFocus()
            onFocusRequested()
        }
    }

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = Dimensions.Padding.half),
            text = title,
        )

        val keyboardOptions = KeyboardOptions(
            capitalization = capitalization
                ?: if (keyboardType == KeyboardType.Text) KeyboardCapitalization.Sentences else KeyboardCapitalization.None,
            imeAction = imeAction?.imeAction ?: ImeAction.Default,
            keyboardType = keyboardType,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            maxLines = maxLines,
            placeholder = {
                Text(textInput.placeholder)
            },
            value = textInput.value,
            onValueChange = onValueChange,
            isError = textInput.error.isNotEmpty(),
            keyboardActions = KeyboardActions(
                onNext = {
                    if (imeAction is TextInputFieldImeAction.Next) {
                        imeAction.focusManager.moveFocus(imeAction.direction)
                        imeAction.action()
                    }
                },
                onSend = {
                    if (imeAction is TextInputFieldImeAction.Send) {
                        imeAction.action()
                    }
                },
                onGo = {
                    if (imeAction is TextInputFieldImeAction.Go) {
                        imeAction.action()
                    }
                },
                onDone = {
                    if (imeAction is TextInputFieldImeAction.Done) {
                        imeAction.action()
                    }
                },
                onPrevious = {
                    if (imeAction is TextInputFieldImeAction.Search) {
                        imeAction.action()
                    }
                },
                onSearch = {
                    if (imeAction is TextInputFieldImeAction.Search) {
                        imeAction.action()
                    }
                }
            ),
        )

        if (textInput.error.isNotEmpty()) {
            Text(
                text = textInput.error,
                modifier = Modifier.padding(start = Dimensions.Padding.default),
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

sealed class TextInputFieldImeAction(val imeAction: ImeAction) {

    abstract val action: () -> Unit

    class Go(override val action: () -> Unit = {}) : TextInputFieldImeAction(ImeAction.Go)
    class Search(override val action: () -> Unit = {}) : TextInputFieldImeAction(ImeAction.Search)
    class Send(override val action: () -> Unit = {}) : TextInputFieldImeAction(ImeAction.Send)
    class Next(
        val focusManager: FocusManager,
        val direction: FocusDirection = FocusDirection.Next,
        override val action: () -> Unit = {},
    ) : TextInputFieldImeAction(ImeAction.Next)

    class Done(override val action: () -> Unit = {}) : TextInputFieldImeAction(ImeAction.Done)
}
