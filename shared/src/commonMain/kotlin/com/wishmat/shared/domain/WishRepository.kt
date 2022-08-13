package com.wishmat.shared.domain

import com.wishmat.shared.viewmodel.addwish.CreateWish

interface WishRepository {

    suspend fun add(wish: CreateWish): Wish

    suspend fun remove(wish: Wish)
}
