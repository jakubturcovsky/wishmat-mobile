package com.wishmat.shared.viewmodel.addwish

import com.wishmat.shared.domain.Wish
import kotlinx.serialization.Serializable

@Serializable
data class CreateWish(
    val name: Wish.Name,
)
