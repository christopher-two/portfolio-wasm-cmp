package org.christophertwo.portfolio.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class PortfolioStyleCardViewModel : ViewModel() {

    private val _state = MutableStateFlow(PortfolioStyleCardState())
    val state = _state
        .onStart { }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = PortfolioStyleCardState()
        )

    fun onAction(action: PortfolioStyleCardAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}