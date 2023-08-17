package com.example.newyorkcity

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.newyorkcity.model.LocationModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CompactMenuScreen() {
    val viewModel: NewYorkViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    BoroughList(
        boroughs = uiState.boroughs
    )
}

@Composable
fun BoroughList(
    boroughs: List<LocationModel>,
    modifier: Modifier = Modifier
){
    LazyColumn{
        items(boroughs) {
            BoroughLayout(location = it)
        }
    }
}

@Composable
fun BoroughLayout(
    location: LocationModel
) {
    Row(){

    }
}