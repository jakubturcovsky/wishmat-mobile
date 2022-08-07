package com.wishmat.shared.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import com.wishmat.shared.AppInfo
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule,
        )
    }

    val koin = koinApplication.koin
    val kermit = koin.get<Logger> { parametersOf(null) }
    // AppInfo is a Kotlin interface with separate Android and iOS implementations
    val appInfo = koin.get<AppInfo>()
    kermit.v { "App Id ${appInfo.appId}" }

    return koinApplication
}

private val coreModule = module {
    val baseLogger = Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "KampKit")
    factory { (tag: String?) -> if (tag != null) baseLogger.withTag(tag) else baseLogger }
}

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

fun KoinComponent.injectLogger(tag: String): Lazy<Logger> = inject { parametersOf(tag) }

expect val platformModule: Module
