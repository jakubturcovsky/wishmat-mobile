package com.wishmat.shared.domain

interface WishService {

    suspend fun create(wish: Wish): Wish

    suspend fun delete(wish: Wish)
}
