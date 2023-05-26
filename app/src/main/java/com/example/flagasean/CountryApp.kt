package com.example.flagasean

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dariwan.flagcountryasean.navigation.Screen
import com.example.flagasean.ui.detail.DetailPage
import com.example.flagasean.ui.home.HomeScreen
import com.example.flagasean.ui.profile.ProfileScreen


@Composable
fun CountryApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,){
        //home
        composable(Screen.Home.route){
            HomeScreen(
                navigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                navigatetoDetail = {countryId->
                    navController.navigate(Screen.Detail.createRoute(countryId))
                }
            )
        }

        //profile
        composable(Screen.Profile.route){
            ProfileScreen(
                navigateUp = {navController.navigateUp()}
            )
        }

        //detail
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("countryId"){
                type = NavType.StringType
            })
        ){
            val id = it.arguments?.getString("countryId") ?: "00"
            DetailPage(
                idCountry = id,
                navigateUp = {navController.navigateUp()}
            )
        }
    }


}

