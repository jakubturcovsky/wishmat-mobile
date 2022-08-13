package com.wishmat.shared.domain

import com.wishmat.shared.viewmodel.addwish.CreateWish

class DefaultWishService(
    private val wishRepository: WishRepository,
) : WishService {

    override suspend fun create(wish: CreateWish): Wish {
        return wishRepository.add(wish)
    }

    override suspend fun delete(wish: Wish) {
        TODO("Not yet implemented")
    }
}
