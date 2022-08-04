pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

include(":android", ":shared")
rootProject.name = "Wishmat"

enableFeaturePreview("VERSION_CATALOGS")
