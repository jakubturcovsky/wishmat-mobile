package com.wishmat.shared.resources

import dev.icerock.moko.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc

interface ResourceResolver {

    fun resolve(string: StringDesc): String

    fun resolve(string: StringResource): String

    fun resolve(plural: PluralsResource, number: Int): String

    fun resolve(plural: PluralsResource, number: Int, vararg arguments: Any): String

    fun resolve(color: ColorResource): Color
}
