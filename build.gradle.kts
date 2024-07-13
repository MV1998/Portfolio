plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

repositories {
    google()  // For Google's Android libraries
    mavenCentral()  // For other Maven dependencies
    // Add other repositories if necessary
}