pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":android", ":shared", ":shared:resources")
rootProject.name = "Wishmat"

enableFeaturePreview("VERSION_CATALOGS")
