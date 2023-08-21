package com.example.newyorkcity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController

enum class NewYorkScreen(){
    MenuScreen,
    ManhattanActivities,
    BronxActivities,
    BrooklynActivities,
    QueensActivities,
    StatenIslandActivities,

    // Manhattan activities
    EmpireStateBuildingDescription,
    MetroMuseumDescription,
    CentralParkDescription,
    TimesSquareDescription,

    // Bronx activities
    BronxZooDescription,
    BronxGardenDescription,
    HipHopMuseumDescription,
    YankeeStadiumDescription,

    // Brooklyn activities
    ConeyIslandDescription,
    BrooklynBotanicGardenDescription,
    ProspectParkDescription,
    BrooklynMuseumDescription,

    // Queens activities
    MuseumOfMovingImageDescription,
    CitiBaseBallFieldDescription,
    FlushingMeadowCoronaParkDescription,
    RockawayBeachDescription,

    //Staten Island
    StatueOfLibertyDescription

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkApp(
    modifier: Modifier = Modifier
) {
    val viewModel: NewYorkViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController: NavHostController = rememberNavController()


    //Compact implementation

    Scaffold(
        topBar = {
            NewYorkTopBar()
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
fun NewYorkTopBar() {
    TopAppBar(
        title = {Text("ExampleText")},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}