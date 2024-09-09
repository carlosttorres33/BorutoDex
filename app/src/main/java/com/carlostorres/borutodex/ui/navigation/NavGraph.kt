package com.carlostorres.borutodex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlostorres.borutodex.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Search.route
    ){

        composable(route = ScreenRoutes.Splash.route){

        }

        composable(route = ScreenRoutes.Welcome.route){

        }

        composable(route = ScreenRoutes.Home.route){

        }

        composable(
            route = ScreenRoutes.Details.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY){
                    type = NavType.IntType
                }
            )
        ){

        }

        composable(route = ScreenRoutes.Search.route){

        }

    }

}