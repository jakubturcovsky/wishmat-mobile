package com.wishmat.shared.domain

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class Url(val value: String)
