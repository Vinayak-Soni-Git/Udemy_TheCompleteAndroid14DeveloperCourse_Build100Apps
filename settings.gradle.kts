pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Udemy_TheCompleteAndroid14DeveloperCourse_Build100Apps"
include(":app")
include(":lib")
include(":app:lib:Kotlin")
 