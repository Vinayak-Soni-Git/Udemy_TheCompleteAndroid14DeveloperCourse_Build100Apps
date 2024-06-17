buildscript {
    val kotlin_version by extra("2.0.0-Beta3")
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.50")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
    repositories {
        mavenCentral()
        google()
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
    id ("com.google.dagger.hilt.android") version "2.50" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta3" apply false
}