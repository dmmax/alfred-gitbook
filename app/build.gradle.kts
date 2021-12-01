plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    application
}
val koinVersion : String by project
val exposedVersion : String by project
val sqliteJdbcVersion : String by project


repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.13.0.202109080827-r")

    // Dependency injection
    implementation("io.insert-koin:koin-core:$koinVersion")

    // Database
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.xerial:sqlite-jdbc:$sqliteJdbcVersion")
    // Testing
    testImplementation("io.insert-koin:koin-test:$koinVersion")
}

application {
    // Define the main class for the application.
    mainClass.set("me.dmmax.alfred.gitbook.AppKt")
}
