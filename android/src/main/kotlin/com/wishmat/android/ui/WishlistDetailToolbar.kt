package com.wishmat.android.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.wishmat.android.R
import com.wishmat.shared.domain.WishlistName

@Composable
fun WishlistDetailToolbar(
    wishlistName: WishlistName,
    showUpButton: Boolean = true,
    navController: NavHostController,
    actions: (@Composable RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = {
            Text(text = wishlistName.value)
        },
        navigationIcon = if (showUpButton) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_arrow_back_24),
                        contentDescription = "Up",  // TODO: string.xml
                    )
                }
            }
        } else {
            null
        },
        actions = actions,
    )
}
