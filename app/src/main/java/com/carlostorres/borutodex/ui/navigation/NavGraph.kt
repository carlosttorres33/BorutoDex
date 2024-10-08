package com.carlostorres.borutodex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlostorres.borutodex.ui.details.DetailsScreen
import com.carlostorres.borutodex.ui.home.HomeScreen
import com.carlostorres.borutodex.ui.search.SearchScreen
import com.carlostorres.borutodex.ui.splash.SplashScreen
import com.carlostorres.borutodex.ui.welcome.WelcomeScreen
import com.carlostorres.borutodex.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Splash.route
    ){

        composable(route = ScreenRoutes.Splash.route){
            SplashScreen(navController = navController)
        }

        composable(route = ScreenRoutes.Welcome.route){
            WelcomeScreen(navController = navController)
        }

        composable(route = ScreenRoutes.Home.route){
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = ScreenRoutes.Details.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY){
                    type = NavType.IntType
                }
            )
        ){
            DetailsScreen(navController = navController)
        }

        composable(route = ScreenRoutes.Search.route){
            SearchScreen(navController = navController)
        }

    }

}