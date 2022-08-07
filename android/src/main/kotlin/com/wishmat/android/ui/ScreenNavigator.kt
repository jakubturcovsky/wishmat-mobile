package com.wishmat.android.ui

import androidx.navigation.NavController

interface ScreenNavigator {

    val navController: NavController

    fun navigateUp() {
        navController.navigateUp()
    }
}
