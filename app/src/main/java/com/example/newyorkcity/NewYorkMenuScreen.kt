package com.example.newyorkcity

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newyorkcity.model.LocationModel

@Composable
fun CompactMenuScreen() {
    val viewModel: NewYorkViewModel

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

}