package com.example.newyorkcity

import androidx.navigation.NavController
import junit.framework.TestCase.assertEquals

fun NavController.assertRouteName(expectedRoute: String) {
    assertEquals(expectedRoute, currentBackStackEntry?.destination?.route)
}