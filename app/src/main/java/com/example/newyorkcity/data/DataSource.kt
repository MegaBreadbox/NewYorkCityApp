package com.example.newyorkcity.data

import com.example.newyorkcity.NewYorkScreen
import com.example.newyorkcity.R
import com.example.newyorkcity.model.LocationModel

object DataSource {
    val locations = listOf(
        LocationModel(
            locationImage = R.drawable.manhattan_bridge,
            locationName = R.string.manhattan,
            locationDescription = R.string.manhattan,
            navigation = NewYorkScreen.ManhattanActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.urban_554606_1280,
            locationName = R.string.the_bronx,
            locationDescription = R.string.the_bronx,
            navigation = NewYorkScreen.BronxActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.new_york_city_104659_1280,
            locationName = R.string.brooklyn,
            locationDescription = R.string.brooklyn,
            navigation = NewYorkScreen.BrooklynActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.flushing_4250265_1280,
            locationName = R.string.queens,
            locationDescription = R.string.queens,
            navigation = NewYorkScreen.QueensActivities.name
        ),
        LocationModel(
            locationImage = R.drawable.new_york_1800020_1280,
            locationName = R.string.staten_island,
            locationDescription = R.string.staten_island,
            navigation = NewYorkScreen.StatenIslandActivities.name
        )
    )

    val manhattanActivities = listOf(
        LocationModel(
            locationImage = R.drawable.empire_state_building,
            locationName = R.string.empire_state_building,
            locationDescription = R.string.empire_description,
            navigation = NewYorkScreen.EmpireStateBuildingDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.metropolitan_museum_of_art_754843_1280,
            locationName = R.string.metropolitan_museum_of_art,
            locationDescription = R.string.met_museum_description,
            navigation = NewYorkScreen.MetroMuseumDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.central_park,
            locationName = R.string.central_park,
            locationDescription = R.string.central_park_description,
            navigation = NewYorkScreen.CentralParkDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.times_square,
            locationName = R.string.times_square,
            locationDescription = R.string.times_square_description,
            navigation = NewYorkScreen.TimesSquareDescription.name
        )
    )

    val bronxActivities = listOf(
        LocationModel(
            locationImage = R.drawable.yankee_stadium,
            locationName = R.string.yankee_stadium,
            locationDescription = R.string.yankee_stadium_description,
            navigation = NewYorkScreen.YankeeStadiumDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.bronxzoo,
            locationName = R.string.bronx_zoo,
            locationDescription = R.string.bronx_zoo,
            navigation = NewYorkScreen.BronxZooDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.bronx_botanical_garden,
            locationName = R.string.bronx_botanical_garden,
            locationDescription = R.string.bronx_botanical_garden,
            navigation = NewYorkScreen.BronxGardenDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.universal_hip_hop_museum,
            locationName = R.string.universal_hip_hop_museum,
            locationDescription = R.string.hiphop_museum_description,
            navigation = NewYorkScreen.HipHopMuseumDescription.name
        )
    )

    val brooklynActivities = listOf(
        LocationModel(
            locationImage = R.drawable.coney_island_2233845_1280,
            locationName = R.string.luna_park,
            locationDescription = R.string.luna_park_description,
            navigation = NewYorkScreen.LunaParkDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.prospect_park,
            locationName = R.string.prospect_park,
            locationDescription = R.string.prospect_park_description,
            navigation = NewYorkScreen.ProspectParkDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.brooklyn_botanic_garden,
            locationName = R.string.brooklyn_botanic_garden,
            locationDescription = R.string.brooklyn_botanic_garden_description,
            navigation = NewYorkScreen.BrooklynBotanicGardenDescription.name,
        ),
        LocationModel(
            locationImage = R.drawable.brooklyn_museum,
            locationName = R.string.brooklyn_musuem,
            locationDescription = R.string.brooklyn_museum_description,
            navigation = NewYorkScreen.BrooklynMuseumDescription.name
        )

    )

    val queensActivities = listOf(
        LocationModel(
            locationImage = R.drawable.globe_2965480_1280,
            locationName = R.string.corona_park,
            locationDescription = R.string.corona_park_description,
            navigation = NewYorkScreen.FlushingMeadowCoronaParkDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.citi_baseball_stadium,
            locationName = R.string.citi_field,
            locationDescription = R.string.citi_field_description,
            navigation = NewYorkScreen.CitiBaseBallFieldDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.museum_of_the_moving_image,
            locationName = R.string.museum_of_the_moving_image,
            locationDescription = R.string.museum_of_the_moving_image_description,
            navigation = NewYorkScreen.MuseumOfMovingImageDescription.name
        ),
        LocationModel(
            locationImage = R.drawable.rockaway_beach_4754134_1280,
            locationName = R.string.rockaway_beach,
            locationDescription = R.string.rockaway_beach_description,
            navigation = NewYorkScreen.RockawayBeachDescription.name
        )
    )

    val statenIslandActivities = listOf(
        LocationModel(
            locationImage = R.drawable.america_2328689_1280,
            locationName = R.string.statue_of_liberty,
            locationDescription = R.string.statue_of_liberty_description,
            navigation = NewYorkScreen.StatueOfLibertyDescription.name
        )
    )

}