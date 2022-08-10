package com.wishmat.shared.viewmodel.addwish

import com.wishmat.shared.viewmodel.TextInput
import com.wishmat.shared.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable

class AddWishViewModel : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Default)
    val state: StateFlow<State> = _state.asStateFlow()

    val name = MutableStateFlow(TextInput(title = "Name", placeholder = "Rainbow-colored Unicorn"))
    val description = MutableStateFlow(TextInput(title = "Description", placeholder = "full rainbow colors, pointy horn"))
    val url = MutableStateFlow(TextInput(title = "Link", placeholder = "https://amazon.com/rainbow-unicorn"))

    fun onNameChanged(input: String) {
        val currentName = name.value
        name.value = currentName.copy(value = input)
        if (currentName.error.isNotEmpty()) {
            validateName()
        }
    }

    fun onDescriptionChanged(input: String) {
        val currentDescription = description.value
        description.value = currentDescription.copy(value = input)
        if (currentDescription.error.isNotEmpty()) {
            validateDescription()
        }
    }

    fun onUrlChanged(input: String) {
        val currentUrl = url.value
        url.value = currentUrl.copy(value = input)
        if (currentUrl.error.isNotEmpty()) {
            validateUrl()
        }
    }

    // TODO: Optimize validation methods, create validator class and common validators for most used validations
    private fun validateName() {
        if (name.value.value.isEmpty()) {
            name.value = name.value.copy(error = "Name cannot be empty!")   // TODO: Validation example, use real validation and Moko resources
        }
    }

    private fun validateDescription() {
        // TODO: Validate
    }

    private fun validateUrl() {
        // TODO: Validate
    }

    private fun validateAll() {
        validateName()
        validateDescription()
        validateUrl()
    }

    fun createWish() {
        validateAll()
        // TODO: Inject domain service & call wish creation method
    }

    @Serializable
    data class UiState(
        val name: String,
        val description: String,
        val url: String,
    ) {

    }

    sealed interface State {

        object Default : State
    }
}
