package com.carlostorres.borutodex.ui.navigation

import com.carlostorres.borutodex.util.Constants.DETAILS_ARGUMENT_KEY

sealed class ScreenRoutes (val route : String){

    object Splash : ScreenRoutes(route = "Splash")
    object Welcome : ScreenRoutes(route = "Welcome")
    object Home : ScreenRoutes(route = "Home")

    object Details : ScreenRoutes(route = "Details/{$DETAILS_ARGUMENT_KEY}"){
        fun passHeroID(heroID : Int) : String {
            return "Details/$heroID"
        }
    }

    object Search : ScreenRoutes(route = "Search")

}