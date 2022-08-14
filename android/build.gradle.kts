plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.wishmat.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":shared:resources"))
    implementation(libs.bundles.android.compose)
    implementation(libs.bundles.androidx)
    // TODO: Remove after resolving hiding default ActionBar without using NoActionBar xml theme in manifest
    implementation("com.google.android.material:material:1.6.1")

    debugImplementation(libs.compose.tooling)
}
