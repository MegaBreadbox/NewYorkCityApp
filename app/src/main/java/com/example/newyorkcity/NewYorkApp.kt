package com.example.newyorkcity

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController

enum class NewYorkScreen(@StringRes val topBarTitle: Int){
    MenuScreen(topBarTitle = R.string.app_name),
    ManhattanActivities(topBarTitle = R.string.manhattan),
    BronxActivities(topBarTitle = R.string.the_bronx),
    BrooklynActivities(topBarTitle = R.string.brooklyn),
    QueensActivities(topBarTitle = R.string.queens),
    StatenIslandActivities(topBarTitle = R.string.staten_island),

    // Manhattan activities
    EmpireStateBuildingDescription(topBarTitle = R.string.empire_state_building),
    MetroMuseumDescription(topBarTitle = R.string.metropolitan_museum_of_art),
    CentralParkDescription(topBarTitle = R.string.central_park),
    TimesSquareDescription(topBarTitle = R.string.times_square),

    // Bronx activities
    BronxZooDescription(topBarTitle = R.string.bronx_zoo),
    BronxGardenDescription(topBarTitle = R.string.bronx_botanical_garden),
    HipHopMuseumDescription(topBarTitle = R.string.universal_hip_hop_museum),
    YankeeStadiumDescription(topBarTitle = R.string.yankee_stadium),

    // Brooklyn activities
    LunaParkDescription(topBarTitle = R.string.luna_park),
    BrooklynBotanicGardenDescription(topBarTitle = R.string.brooklyn_botanic_garden),
    ProspectParkDescription(topBarTitle = R.string.prospect_park),
    BrooklynMuseumDescription(topBarTitle = R.string.brooklyn_musuem),

    // Queens activities
    MuseumOfMovingImageDescription(topBarTitle = R.string.museum_of_the_moving_image),
    CitiBaseBallFieldDescription(topBarTitle = R.string.citi_field),
    FlushingMeadowCoronaParkDescription(topBarTitle = R.string.corona_park),
    RockawayBeachDescription(topBarTitle = R.string.rockaway_beach),

    //Staten Island activities
    StatueOfLibertyDescription(topBarTitle = R.string.statue_of_liberty)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkTopBar(
    currentScreen: NewYorkScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.topBarTitle)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val viewModel: NewYorkViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NewYorkScreen.valueOf(
        backStackEntry?.destination?.route ?: NewYorkScreen.MenuScreen.name
    )

    //Compact implementation

    Scaffold(
        topBar = {
            NewYorkTopBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                currentScreen = currentScreen
            )
        }
    ) { padding ->
        //CompactMenuScreen(uiState.boroughs)
        Column(modifier = Modifier.padding(padding)){
            //CompactMenuScreen(uiState.boroughs)

            NavHost(
                navController = navController,
                startDestination = NewYorkScreen.MenuScreen.name,
                modifier = Modifier
            ){
                composable(route = NewYorkScreen.MenuScreen.name) {
                    CompactMenuScreen(
                        boroughs = uiState.boroughs,
                        viewModel = viewModel,
                        onClick = { navController.navigate(it) }

                    )
                }
                if(windowSize == WindowWidthSizeClass.Compact) {
                    composable(route = NewYorkScreen.ManhattanActivities.name) {
                        CompactMenuScreen(
                            boroughs = uiState.manhattanActivities,
                            viewModel = viewModel,
                            onClick = { navController.navigate(it) }
                        )
                    }
                    composable(route = NewYorkScreen.BronxActivities.name) {
                        CompactMenuScreen(
                            boroughs = uiState.bronxActivities,
                            viewModel = viewModel,
                            onClick = { navController.navigate(it) }
                        )
                    }
                    composable(route = NewYorkScreen.BrooklynActivities.name) {
                        CompactMenuScreen(
                            boroughs = uiState.brooklynActivities,
                            viewModel = viewModel,
                            onClick = { navController.navigate(it) }
                        )
                    }
                    composable(route = NewYorkScreen.QueensActivities.name) {
                        CompactMenuScreen(
                            boroughs = uiState.queensActivities,
                            viewModel = viewModel,
                            onClick = { navController.navigate(it) }
                        )
                    }
                    composable(route = NewYorkScreen.StatenIslandActivities.name) {
                        CompactMenuScreen(
                            boroughs = uiState.statenIslandActivities,
                            viewModel = viewModel,
                            onClick = { navController.navigate(it) }
                        )
                    }
                    // third screen routes

                    composable(route = NewYorkScreen.EmpireStateBuildingDescription.name) {
                        DetailScreen(
                            image = R.drawable.empire_state_building,
                            textBody = stringResource(R.string.empire_description)
                        )
                    }
                    composable(route = NewYorkScreen.MetroMuseumDescription.name) {
                        DetailScreen(
                            image = R.drawable.metropolitan_museum_of_art_754843_1280,
                            textBody = stringResource(R.string.met_museum_description)
                        )
                    }
                    composable(route = NewYorkScreen.CentralParkDescription.name) {
                        DetailScreen(
                            image = R.drawable.central_park,
                            textBody = stringResource(R.string.central_park_description)
                        )
                    }
                    composable(route = NewYorkScreen.TimesSquareDescription.name) {
                        DetailScreen(
                            image = R.drawable.times_square,
                            textBody = stringResource(R.string.times_square_description)
                        )
                    }
                    composable(route = NewYorkScreen.YankeeStadiumDescription.name) {
                        DetailScreen(
                            image = R.drawable.yankee_stadium,
                            textBody = stringResource(R.string.yankee_stadium_description)
                        )
                    }
                    composable(route = NewYorkScreen.BronxZooDescription.name) {
                        DetailScreen(
                            image = R.drawable.bronxzoo,
                            textBody = stringResource(R.string.bronx_zoo_description)
                        )
                    }
                    composable(route = NewYorkScreen.BronxGardenDescription.name) {
                        DetailScreen(
                            image = R.drawable.bronx_botanical_garden,
                            textBody = stringResource(R.string.bronx_botanical_garden_description)
                        )
                    }
                    composable(route = NewYorkScreen.HipHopMuseumDescription.name) {
                        DetailScreen(
                            image = R.drawable.universal_hip_hop_museum,
                            textBody = stringResource(R.string.hiphop_museum_description)
                        )
                    }
                    composable(route = NewYorkScreen.LunaParkDescription.name) {
                        DetailScreen(
                            image = R.drawable.coney_island_2233845_1280,
                            textBody = stringResource(R.string.luna_park_description)
                        )
                    }
                    composable(route = NewYorkScreen.ProspectParkDescription.name) {
                        DetailScreen(
                            image = R.drawable.prospect_park,
                            textBody = stringResource(R.string.prospect_park_description)
                        )
                    }
                    composable(route = NewYorkScreen.BrooklynBotanicGardenDescription.name) {
                        DetailScreen(
                            image = R.drawable.brooklyn_botanic_garden,
                            textBody = stringResource(R.string.brooklyn_botanic_garden_description)
                        )
                    }
                    composable(route = NewYorkScreen.BrooklynMuseumDescription.name) {
                        DetailScreen(
                            image = R.drawable.brooklyn_museum,
                            textBody = stringResource(R.string.brooklyn_museum_description)
                        )
                    }
                    composable(route = NewYorkScreen.FlushingMeadowCoronaParkDescription.name) {
                        DetailScreen(
                            image = R.drawable.globe_2965480_1280,
                            textBody = stringResource(R.string.corona_park_description)
                        )
                    }
                    composable(route = NewYorkScreen.CitiBaseBallFieldDescription.name) {
                        DetailScreen(
                            image = R.drawable.citi_baseball_stadium,
                            textBody = stringResource(R.string.citi_field_description)
                        )
                    }
                    composable(route = NewYorkScreen.MuseumOfMovingImageDescription.name) {
                        DetailScreen(
                            image = R.drawable.museum_of_the_moving_image,
                            textBody = stringResource(R.string.museum_of_the_moving_image_description)
                        )
                    }
                    composable(route = NewYorkScreen.RockawayBeachDescription.name) {
                        DetailScreen(
                            image = R.drawable.rockaway_beach_4754134_1280,
                            textBody = stringResource(R.string.rockaway_beach_description)
                        )
                    }
                    composable(route = NewYorkScreen.StatueOfLibertyDescription.name) {
                        DetailScreen(
                            image = R.drawable.america_2328689_1280,
                            textBody = stringResource(R.string.statue_of_liberty_description)
                        )
                    }
                } else {
                    composable(route = NewYorkScreen.ManhattanActivities.name) {
                        MediumMenuScreen(
                            boroughs = uiState.manhattanActivities,
                            image = uiState.activeLocation.locationImage,
                            textBody = uiState.activeLocation.locationDescription,
                            onClick = { },
                            viewModel = viewModel
                        )
                    }
                }

            }
        }
    }
}