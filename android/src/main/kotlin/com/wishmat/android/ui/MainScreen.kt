package com.wishmat.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wishmat.android.ui.theme.AppTheme
import com.wishmat.shared.domain.WishlistName

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val wishlistName = WishlistName("")
    val tabs = remember {
        listOf(AppScreen.Home, AppScreen.AddWish, AppScreen.Settings)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        topBar = {
             WishlistDetailToolbar(wishlistName = wishlistName, navController = navController)
        },
        bottomBar = {
            BottomNavigation {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = { Icon(painterResource(id = tab.imageRes), contentDescription = tab.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true,
                        onClick = {
                            if (currentDestination?.hierarchy?.any { it.route == tab.route } == true) {
                                return@BottomNavigationItem
                            }
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        enabled = tab == AppScreen.Home,
                    )
                }
            }
        },
    ) { contentPadding ->
        AppNavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController,
        )
    }
    Text(text = "Hi mom!")
}

@Preview
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}
