package com.example.newyorkcity

import com.example.newyorkcity.data.DataSource
import com.example.newyorkcity.model.LocationModel

data class NewYorkUiState(
    val boroughs: List<LocationModel> = DataSource.locations,
    val manhattanActivities: List<LocationModel> = DataSource.manhattanActivities,
    val bronxActivities: List<LocationModel> = DataSource.bronxActivities,
    val brooklynActivities: List<LocationModel> = DataSource.brooklynActivities,
    val queensActivities: List<LocationModel> = DataSource.queensActivities,
    val statenIslandActivities: List<LocationModel> = DataSource.statenIslandActivities,

    val activeLocation: LocationModel = DataSource.manhattanActivities[0]
    )