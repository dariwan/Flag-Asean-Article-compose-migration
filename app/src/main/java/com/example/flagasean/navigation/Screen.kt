package com.dariwan.flagcountryasean.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail: Screen("home/{countryId}"){
        fun createRoute(countryId: String) = "home/${countryId}"
    }
}