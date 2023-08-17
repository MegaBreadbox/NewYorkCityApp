package com.example.newyorkcity

import androidx.lifecycle.ViewModel
import com.example.newyorkcity.data.DataSource
import com.example.newyorkcity.model.LocationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewYorkViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(DataSource.locations))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
}

data class UiState(
    val boroughs: List<LocationModel>
)
