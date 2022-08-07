package com.wishmat.shared.di

import co.touchlab.kermit.Logger
import com.wishmat.shared.AppInfo
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

fun initKoinIos(
    userDefaults: NSUserDefaults,
    appInfo: AppInfo,
    doOnStartup: () -> Unit,
): KoinApplication = initKoin(
    module {
        single { appInfo }
        single { doOnStartup }
    }
)

actual val platformModule = module {
    // single { HomeCallbackViewModel(get(), getWith("HomeCallbackViewModel")) }
}

fun Koin.loggerWithTag(tag: String) = get<Logger>(qualifier = null) { parametersOf(tag) }

object KotlinDependencies : KoinComponent {
    // fun getHomeViewModel() = getKoin().get<HomeCallbackViewModel>()
}
