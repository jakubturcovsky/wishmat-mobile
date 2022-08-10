package com.wishmat.shared.domain

import com.benasher44.uuid.Uuid
import kotlin.jvm.JvmInline

data class Wishlist(
    val id: Id? = null,
    val name: Name,
    val visibility: Visibility,
    val wishes: List<Wish>,
) {

    @JvmInline
    value class Id(val value: Uuid)

    @JvmInline
    value class Name(val value: String)
}
