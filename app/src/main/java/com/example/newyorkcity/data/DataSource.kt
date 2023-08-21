package com.example.newyorkcity.data

import com.example.newyorkcity.NewYorkScreen
import com.example.newyorkcity.R
import com.example.newyorkcity.model.LocationModel

object DataSource {
    val locations = listOf(
        LocationModel(
            locationImage = R.drawable.manhattan_bridge,
            locationName = R.string.manhattan,
            navigation = NewYorkScreen.ManhattanActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.urban_554606_1280,
            locationName = R.string.the_bronx,
            navigation = NewYorkScreen.BronxActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.new_york_city_104659_1280,
            locationName = R.string.brooklyn,
            navigation = NewYorkScreen.BrooklynActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.flushing_4250265_1280,
            locationName = R.string.queens,
            navigation = NewYorkScreen.QueensActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.new_york_1800020_1280,
            locationName = R.string.staten_island,
            navigation = NewYorkScreen.StatenIslandActivities.name
        )
    )

    val manhattanActivities = listOf(
        LocationModel(
            locationImage = R.drawable.empire_state_building,
            locationName = R.string.empire_state_building,
            navigation = NewYorkScreen.EmpireStateBuildingDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.metropolitan_museum_of_art_754843_1280,
            locationName = R.string.metropolitan_museum_of_art,
            navigation = NewYorkScreen.MetroMuseumDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.central_park,
            locationName = R.string.central_park,
            navigation = NewYorkScreen.CentralParkDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.times_square,
            locationName = R.string.times_square,
            navigation = NewYorkScreen.TimesSquareDescription.name
        )
    )

    val bronxActivities = listOf(
        LocationModel(
            locationImage = R.drawable.yankee_stadium,
            locationName = R.string.yankee_stadium,
            navigation = NewYorkScreen.YankeeStadiumDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.bronxzoo,
            locationName = R.string.bronx_zoo,
            navigation = NewYorkScreen.BronxZooDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.bronx_botanical_garden,
            locationName = R.string.bronx_botanical_garden,
            navigation = NewYorkScreen.BronxGardenDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.universal_hip_hop_museum,
            locationName = R.string.universal_hip_hop_museum,
            navigation = NewYorkScreen.HipHopMuseumDescription.name
        )
    )

    val brooklynActivities = listOf(
        LocationModel(
            locationImage = R.drawable.coney_island_2233845_1280,
            locationName = R.string.coney_island,
            navigation = NewYorkScreen.ConeyIslandDescription.name
        )
    )

}