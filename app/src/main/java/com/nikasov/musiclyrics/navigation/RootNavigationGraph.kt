package com.nikasov.musiclyrics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nikasov.musiclyrics.feature.home.HomeScreen
import com.nikasov.musiclyrics.feature.splash.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.Root.route,
        startDestination = Graph.Home.route
    ) {
        composable(route = Graph.Splash.route) { SplashScreen { navController.navigate(Graph.Home.route) } }
        composable(route = Graph.Home.route) { HomeScreen() }
    }

}

enum class Graph(val route: String) {
    Root("root"),
    Splash("splash"),
    Home("home")
}