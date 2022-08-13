package com.wishmat.shared.infrastructure

import com.benasher44.uuid.uuid4
import com.wishmat.shared.domain.Wish
import com.wishmat.shared.domain.WishRepository
import com.wishmat.shared.viewmodel.addwish.CreateWish

class FakeWishRepository : WishRepository {

    override suspend fun add(wish: CreateWish): Wish {
        return Wish(
            id = Wish.Id(uuid4()),
            name = wish.name,
            description = wish.description,
            url = wish.url,
        ).also(FakeDatabase.wishes::add)
    }

    override suspend fun remove(wish: Wish) {
        FakeDatabase.wishes.remove(wish)
    }
}
