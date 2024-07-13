import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }


    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        //    implementation("androidx.compose.material3:material3:1.2.1")
          //  implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
        }
    }
}
//
//dependencies {
//    commonMainImplementation("androidx.compose.material3:material3:1.2.1")
//    commonMainImplementation("androidx.compose.material3:material3-window-size-class:1.2.1")
//}
//

/*

//            implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
//            implementation("androidx.compose.runtime:runtime:1.0.0")
//            implementation("androidx.compose.ui:ui:1.0.0")
          //  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

           // implementation("androidx.compose.material3.adaptive:adaptive-layout:1.0.0-beta03")

            //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
            //implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
          //  implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.2")
 */
