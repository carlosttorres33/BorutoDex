package com.carlostorres.borutodex.navigation

import com.carlostorres.borutodex.util.Constants.DETAILS_ARGUMENT_KEY

sealed class Screen (val route : String){

    object Splash : Screen(route = "Splash")
    object Welcome : Screen(route = "Welcome")
    object Home : Screen(route = "Home")

    object Details : Screen(route = "Details/{$DETAILS_ARGUMENT_KEY}"){
        fun passHeroID(heroID : Int) : String {
            return "Details/$heroID"
        }
    }

    object Search : Screen(route = "Search")

}