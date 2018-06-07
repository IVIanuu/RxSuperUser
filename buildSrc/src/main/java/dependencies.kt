@file:Suppress("ClassName", "unused")

object Versions {
    // android
    const val compileSdk = 28
    const val minSdk = 14
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.2.41"
    const val mavenGradle = "2.1"
    const val rxJava = "2.1.14"
    const val support = "28.0.0-alpha3"
    const val superUser = "1.0.0.+"
}
//
object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.1.2"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"

    const val mavenGradlePlugin = "com.github.dcendents:android-maven-gradle-plugin:${Versions.mavenGradle}"

    const val supportAppCompat = "com.android.support:appcompat-v7:${Versions.support}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    const val superUser = "eu.chainfire:libsuperuser:1.0.0.+"
}