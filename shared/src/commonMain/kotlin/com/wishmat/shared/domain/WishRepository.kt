package com.wishmat.shared.domain

interface WishRepository {

    suspend fun add(wish: Wish): Wish

    suspend fun remove(wish: Wish)
}
