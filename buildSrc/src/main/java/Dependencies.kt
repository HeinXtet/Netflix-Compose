object Versions {
    const val gradlePlugin = "4.2.1"
    const val kotlin = "1.6.10"
    const val timber = "4.7.1"
    const val appCompat = "1.3.0"
    const val material = "1.3.0"
    const val constraintLayout = "1.1.3"
    const val jUnit = "4.12"
    const val compose = "1.1.1"
    const val coreKtx = "1.7.0"
    const val lifecycle = "2.3.1"
    const val activityCompose = "1.3.1"

    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"

    const val systemUIController = "0.17.0"
    const val navigationController = "2.4.2"

    const val hilt = "2.38.1"
    const val composeViewModel = "2.4.1"
    const val composeViewModelNavGraph = "1.0.0"
    const val composeConstraintLayout = "1.0.0-beta02"
}


object App {
    const val targetSdk = 32
    const val minSdk = 23
    const val versionCode = 1
    const val versionName = "1.0"
}

object Libraries {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composeViewModelNavGraph = "androidx.hilt:hilt-navigation-compose:${Versions.composeViewModelNavGraph}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val systemuicontroller =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.systemUIController}"

    const val navigationController =
        "androidx.navigation:navigation-compose:${Versions.navigationController}"

    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val daggerHiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"


}

object TestingLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
}


object Modules {
    const val domain = ":domain"
    const val data = ":data"
    const val network = ":network"
    const val common = ":common"
}