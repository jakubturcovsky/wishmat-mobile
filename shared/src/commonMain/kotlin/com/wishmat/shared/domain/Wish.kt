package com.wishmat.shared.domain

import com.benasher44.uuid.Uuid
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

data class Wish(
    val id: Id? = null,
    val name: Name,
    val description: Description,
    val url: Url,
) {

    @JvmInline
    value class Id(val value: Uuid)

    @Serializable
    @JvmInline
    value class Name(val value: String = "")

    @JvmInline
    value class Description(val value: String = "")
}
