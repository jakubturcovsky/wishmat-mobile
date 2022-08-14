package com.wishmat.shared.resources

import android.content.Context
import dev.icerock.moko.graphics.Color
import dev.icerock.moko.resources.*
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

class AndroidResourceResolver(private val context: Context) : ResourceResolver {

    override fun resolve(string: StringDesc): String = string.toString(context)

    override fun resolve(string: StringResource): String = resolve(string.desc())

    override fun resolve(plural: PluralsResource, number: Int): String = resolve(plural.format(number, listOf(number)))

    override fun resolve(plural: PluralsResource, number: Int, vararg arguments: Any): String =
        resolve(plural.format(number, arguments.toList()))

    override fun resolve(color: ColorResource): Color = color.getColor(context)
}
