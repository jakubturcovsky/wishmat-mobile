package com.wishmat.shared.domain

import com.wishmat.shared.viewmodel.addwish.CreateWish

interface WishService {

    suspend fun create(wish: CreateWish): Wish

    suspend fun delete(wish: Wish)
}
