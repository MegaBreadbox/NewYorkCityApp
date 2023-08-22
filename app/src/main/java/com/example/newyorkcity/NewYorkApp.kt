package com.example.newyorkcity

import androidx.annotation.StringRes
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
    ConeyIslandDescription(topBarTitle = R.string.coney_island),
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
fun NewYorkApp(
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
                        onClick = { navController.navigate(it) }

                    )
                }
                composable(route = NewYorkScreen.ManhattanActivities.name) {
                    CompactMenuScreen(
                        boroughs = uiState.manhattanActivities,
                        onClick = { navController.navigate(it) }
                    )
                }
                composable(route = NewYorkScreen.BronxActivities.name) {
                    CompactMenuScreen(
                        boroughs = uiState.bronxActivities,
                        onClick = { navController.navigate(it) }
                    )
                }
                composable(route = NewYorkScreen.BrooklynActivities.name) {
                    CompactMenuScreen(
                        boroughs = uiState.brooklynActivities,
                        onClick = { navController.navigate(it) }
                    )
                }
                composable(route = NewYorkScreen.QueensActivities.name) {
                    CompactMenuScreen(
                        boroughs = uiState.queensActivities,
                        onClick = { navController.navigate(it) }
                    )
                }
                composable(route = NewYorkScreen.StatenIslandActivities.name) {
                    CompactMenuScreen(
                        boroughs = uiState.statenIslandActivities,
                        onClick = { navController.navigate(it) }
                    )
                }
            }
        }
    }
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