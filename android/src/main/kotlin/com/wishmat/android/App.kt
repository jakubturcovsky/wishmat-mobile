package com.wishmat.android

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.wishmat.shared.AppInfo
import com.wishmat.shared.di.initKoin
import com.wishmat.shared.resources.AndroidResourceResolver
import com.wishmat.shared.resources.ResourceResolver
import com.wishmat.shared.viewmodel.addwish.AddWishViewModel
import com.wishmat.shared.viewmodel.HomeViewModel
import com.wishmat.shared.viewmodel.SettingsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        initKoin(
            module {
                single<Context> { this@App }
                single<AppInfo> { AndroidAppInfo() }

                single<ResourceResolver> { AndroidResourceResolver(get()) }

                single<SharedPreferences> { get<Context>().getSharedPreferences("wishmat_settings", Context.MODE_PRIVATE) }

                single { { Log.i("Startup", "Hello from Android/Kotlin!") } }

                viewModel { HomeViewModel() }
                viewModel { SettingsViewModel() }
                viewModel { AddWishViewModel(get(), get()) }
            }
        )
    }
}
