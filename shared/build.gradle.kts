plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0.0"

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }
}

kotlin {
    android()
    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "Wishmat KMP shared module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "WishmatKit"
        }
    }
    
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.coroutines.core)
                api(libs.touchlab.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.bundles.shared.commonTest)
            }
        }

        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(libs.bundles.shared.androidTest)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
        }
        val iosTest by getting {
            dependsOn(commonTest)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }
    }
}
