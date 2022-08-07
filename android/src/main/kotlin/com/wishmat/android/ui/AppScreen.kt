package com.wishmat.android.ui

import androidx.annotation.DrawableRes
import com.wishmat.android.R

sealed class AppScreen(val route: String, val title: String, @DrawableRes val imageRes: Int) {
    object Home : AppScreen("home", "Home", R.drawable.ic_round_home_24)
    object AddWish : AppScreen("home/add-wish", "Add Wish", R.drawable.ic_round_add_24)
    object Settings : AppScreen("home/settings", "Settings", R.drawable.ic_round_settings_24)
}
