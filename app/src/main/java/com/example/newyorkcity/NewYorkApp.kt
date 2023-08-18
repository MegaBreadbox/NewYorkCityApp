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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

enum class NewYorkScreen(){
    MenuScreen,

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewYorkApp(
    modifier: Modifier = Modifier
) {
    val viewModel: NewYorkViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController: NavController = rememberNavController()
    //Compact implementation

    Scaffold(
        topBar = {
            NewYorkTopBar()
        }
    ) {
        //CompactMenuScreen(uiState.boroughs)
        Column(modifier = Modifier.padding(it)){
            CompactMenuScreen(uiState.boroughs)
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