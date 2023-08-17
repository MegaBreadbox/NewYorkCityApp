package com.example.newyorkcity.data

import com.example.newyorkcity.R
import com.example.newyorkcity.model.LocationModel

object DataSource {
    val locations = listOf(
        LocationModel(
            locationImage = R.drawable.manhattan_bridge,
            locationName = R.string.manhattan
        ),
        LocationModel(
            locationImage = R.drawable.urban_554606_1280,
            locationName = R.string.the_bronx
        ),
        LocationModel(
            locationImage = R.drawable.new_york_city_104659_1280,
            locationName = R.string.brooklyn
        ),
        LocationModel(
            locationImage = R.drawable.flushing_4250265_1280,
            locationName = R.string.queens
        ),
        LocationModel(
            locationImage = R.drawable.new_york_1800020_1280,
            locationName = R.string.staten_island
        )
    )

}