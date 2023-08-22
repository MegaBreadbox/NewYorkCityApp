package com.example.newyorkcity

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavTest {
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController
    @Before
    fun setupNewYorkNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            NewYorkApp(navController = navController)
        }
    }

    @Test
    fun newYorkNavHost_verifyStartDestination() {
        navController.assertRouteName(NewYorkScreen.MenuScreen.name)
    }

    // navigate the first set of screens
    @Test
    fun newYorkNavHost_clickManhattan_verifyManhattanNavigation() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.manhattan))
            .performClick()
        navController.assertRouteName(NewYorkScreen.ManhattanActivities.name)
    }

    @Test
    fun newYorkNavHost_clickBronx_verifyBronxNavigation() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.the_bronx))
            .performClick()
        navController.assertRouteName(NewYorkScreen.BronxActivities.name)
    }

    @Test
    fun newYorkNavHost_clickBrooklyn_verifyBrooklynNavigation() {
        composeTestRule.onNodeWithTag("List")
            .performScrollToNode(hasText(composeTestRule.activity.getString(R.string.brooklyn)))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.brooklyn))
            .performClick()
        navController.assertRouteName(NewYorkScreen.BrooklynActivities.name)
    }

    @Test
    fun newYorkNavHost_clickQueens_verifyQueensNavigation() {
        composeTestRule.onNodeWithTag("List")
            .performScrollToNode(hasText(composeTestRule.activity.getString(R.string.queens)))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.queens))
            .performClick()
        navController.assertRouteName(NewYorkScreen.QueensActivities.name)
    }

    @Test
    fun newYorkNavHost_clickStatenIsland_verifyStatenIslandNavigation() {
        composeTestRule.onNodeWithTag("List")
            .performScrollToNode(hasText(composeTestRule.activity.getString(R.string.staten_island)))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.staten_island))
            .performClick()
        navController.assertRouteName(NewYorkScreen.StatenIslandActivities.name)
    }


}