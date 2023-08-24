package com.example.newyorkcity

import androidx.lifecycle.ViewModel
import com.example.newyorkcity.model.LocationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NewYorkViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NewYorkUiState())
    val uiState: StateFlow<NewYorkUiState> = _uiState.asStateFlow()

    fun currentlySelected(selected: LocationModel) {
        _uiState.update {
            it.copy(
                activeLocation = selected
            )
        }
    }


}


