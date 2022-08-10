package com.wishmat.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wishmat.android.ui.addwish.AddWishScreen
import com.wishmat.android.ui.home.HomeScreen
import com.wishmat.android.ui.settings.SettingsScreen
import com.wishmat.shared.viewmodel.HomeViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.AddWish.route,
        modifier = modifier
    ) {
        composable(AppScreen.Home.route) {
            val viewModel: HomeViewModel by viewModel()
            HomeScreen(viewModel)
        }
        composable(AppScreen.Settings.route) {
            SettingsScreen()
        }
        composable(AppScreen.AddWish.route) {
            AddWishScreen()
        }
    }
}
