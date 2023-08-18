package com.example.newyorkcity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewYorkViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NewYorkUiState())
    val uiState: StateFlow<NewYorkUiState> = _uiState.asStateFlow()


}


