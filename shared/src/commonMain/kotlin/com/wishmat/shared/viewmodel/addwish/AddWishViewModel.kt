package com.wishmat.shared.viewmodel.addwish

import com.wishmat.shared.domain.Url
import com.wishmat.shared.domain.Wish
import com.wishmat.shared.domain.WishService
import com.wishmat.shared.resources.MR
import com.wishmat.shared.resources.ResourceResolver
import com.wishmat.shared.viewmodel.TextInput
import com.wishmat.shared.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

class AddWishViewModel(
    private val resourceResolver: ResourceResolver,
    private val wishService: WishService,
) : ViewModel() {

    val localizations = Localizations()

    private val _state: MutableStateFlow<UiState> = MutableStateFlow(UiState.Default)
    val state: StateFlow<UiState> = _state.asStateFlow()

    val name = MutableStateFlow(TextInput(title = localizations.nameTitle, placeholder = localizations.namePlaceholder))
    val description = MutableStateFlow(TextInput(title = localizations.descriptionTitle, placeholder = localizations.descriptionPlaceholder))
    val url = MutableStateFlow(TextInput(title = localizations.urlTitle, placeholder = localizations.urlPlaceholder))

    private val _focusedError = MutableStateFlow<TextInput?>(null)
    val focusedError: StateFlow<TextInput?> = _focusedError.asStateFlow()

    fun onFocusRequested() {
        _focusedError.value = null
    }

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
    private fun validateName(): Boolean {
        if (name.value.value.isEmpty()) {
            name.value = name.value.copy(error = localizations.nameValidationEmptyError)   // TODO: Validation example, use real validation and Moko resources
            return false
        }

        return true
    }

    private fun validateDescription(): Boolean {
        // TODO: Validate
        return true
    }

    private fun validateUrl(): Boolean {
        // TODO: Validate
        return true
    }

    private fun validateAll(): Boolean {
        if (!validateName()) {
            _focusedError.value = name.value
            return false
        }
        if (!validateDescription()) {
            _focusedError.value = description.value
            return false
        }
        if (!validateUrl()) {
            _focusedError.value = url.value
            return false
        }

        return true
    }

    fun createWish() {
        // TODO: Lock UI or just this method
        _state.value = UiState.Loading

        if (!validateAll()) {
            _state.value = UiState.Default
            return
        }

        val wish = CreateWish(
            name = Wish.Name(name.value.value),
            description = Wish.Description(description.value.value),
            url = Url(url.value.value),
        )
        viewModelScope.launch {
            wishService.create(wish)
            _state.value = UiState.Loading
        }
    }

    @Serializable
    data class State(
        val name: String,
        val description: String,
        val url: String,
    ) {

    }

    sealed interface UiState {

        object Default : UiState
        object Loading : UiState
    }

    inner class Localizations {

        val nameTitle: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Name_Title)
        val namePlaceholder: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Name_Placeholder)
        val nameValidationEmptyError: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Name_ValidationError_Empty)
        val descriptionTitle: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Description_Title)
        val descriptionPlaceholder: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Description_Placeholder)
        val urlTitle: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Url_Title)
        val urlPlaceholder: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Url_Placeholder)
        val create: String
            get() = resourceResolver.resolve(MR.strings.AddWish_Create)
    }
}
