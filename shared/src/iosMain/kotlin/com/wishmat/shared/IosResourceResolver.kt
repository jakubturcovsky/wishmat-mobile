package com.wishmat.shared

import com.wishmat.shared.resources.ResourceResolver
import dev.icerock.moko.graphics.Color
import dev.icerock.moko.resources.*
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import platform.UIKit.UIScreen

class IosResourceResolver : ResourceResolver {

    override fun resolve(string: StringResource): String = resolve(string.desc())

    override fun resolve(string: StringDesc): String = string.localized()

    override fun resolve(plural: PluralsResource, number: Int): String = resolve(plural.format(number, listOf(number)))

    override fun resolve(plural: PluralsResource, number: Int, vararg arguments: Any): String =
        resolve(plural.format(number, arguments.toList()))

    override fun resolve(color: ColorResource): Color = color.getColor(UIScreen.mainScreen.traitCollection.userInterfaceStyle)
}
