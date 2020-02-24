import base.implementation
import dependencies.Dependencies
import base.projectImplementation
import dependencies.coroutinesWithAndroid
import dependencies.daggerWithAndroid
import dependencies.testAndroidDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

const val domain = ":domain"
const val data = ":data"

fun DependencyHandler.appDependencies() {
    appProjects()
    daggerWithAndroid()
    coroutinesWithAndroid()
    implementation(Dependencies.viewModel)
    implementation(Dependencies.extensions)
    implementation(Dependencies.picasso)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.constraitLayout)
    implementation(Dependencies.recyclerView)
    testAndroidDependencies()
}


private fun DependencyHandler.appProjects() {
    projectImplementation(domain)
    projectImplementation(data)
}