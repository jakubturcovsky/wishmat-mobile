package com.wishmat.shared.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Default)
    val state: StateFlow<State> = _state.asStateFlow()

    sealed interface State {

        object Default : State
    }
}
