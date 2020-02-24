import base.implementation
import base.projectImplementation
import dependencies.*
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dataDependencies() {
    projectImplementation(domain)
    dagger()
    implementation(Dependencies.picasso)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidCore)
    testDependencies()
    testAndroidDependencies()
}