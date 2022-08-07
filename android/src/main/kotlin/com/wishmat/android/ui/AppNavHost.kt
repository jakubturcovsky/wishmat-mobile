package com.wishmat.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wishmat.android.ui.addwish.AddWishRoute
import com.wishmat.android.ui.addwish.AddWishScreenNavigator
import com.wishmat.android.ui.home.HomeRoute
import com.wishmat.android.ui.home.HomeScreenNavigator
import com.wishmat.android.ui.settings.SettingsRoute
import com.wishmat.android.ui.settings.SettingsScreenNavigator

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route,
        modifier = modifier
    ) {
        composable(AppScreen.Home.route) {
            HomeRoute(navigator = HomeScreenNavigator(navController))
        }
        composable(AppScreen.Settings.route) {
            SettingsRoute(navigator = SettingsScreenNavigator(navController))
        }
        composable(AppScreen.AddWish.route) {
            AddWishRoute(navigator = AddWishScreenNavigator(navController))
        }
    }
}
