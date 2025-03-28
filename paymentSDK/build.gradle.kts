import com.vanniktech.maven.publish.SonatypeHost
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.29.0"
    id("signing")
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { inputStream ->
        localProperties.load(inputStream)
    }
}
val keystoreProperties = Properties()
val keystorePropertiesFile = rootProject.file("keystore.properties")
if (keystorePropertiesFile.exists()) {
    keystorePropertiesFile.inputStream().use { inputStream ->
        keystoreProperties.load(inputStream)
    }
}
// todo: 28 Mar 2025 -----------------latest method-------------
mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("io.github.lincythomas", "numberFormatter", "1.0.2")

    pom {
        name = "NumberFormatter library"
        description = "Amount Formatter library."
        inceptionYear = "2025"
        url = "https://github.com/lincythomas/NumberFormatter/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "lincythomas"
                name = "Kotlin Developer Advocate"
                url = "https://github.com/lincythomas/"
            }
        }
        scm {
            url = "https://github.com/lincythomas/NumberFormatter/"
            connection = "scm:git:git://github.com/lincythomas/NumberFormatter.git"
            developerConnection = "scm:git:ssh://git@github.com/lincythomas/NumberFormatter.git"
        }
    }
    signing{
        useInMemoryPgpKeys(
//            keystoreProperties["signing.keyId"].toString(),
//            File(keystoreProperties["signing.secretKeyRingFile"].toString()).readText(),
//            keystoreProperties["signing.password"].toString()
            findProperty("signing.keyId") as String?,
            findProperty("signing.secretKeyRingFile") as String?,
            findProperty("signing.password") as String?
        )
    }
}
// end todo: 28 Mar 2025 -----------------latest method-------------

//new ------------ vanniktech.maven.publish------------------

// Publishing to Maven Central setup
//publishing {
//    publications {
//        // Define the release publication
//        register<MavenPublication>("release") {
//            // from(components["release"]) // Use the release build variant
//
//            groupId = "io.github.jiocoders" // Replace with your groupId
//            artifactId = "paymentSDK" // Replace with your artifactId
//            version = "1.0.0" // Replace with your library version
//
//            afterEvaluate {
//                from(components["release"])
//            }
//
//            pom {
//                name.set("Jiocoders")
//                description.set("Sample Payment SDK")
//                url.set("https://github.com/JioCoders/payment_sdk_android.git") // Your project URL
//
//                licenses {
//                    license {
//                        name.set("MIT License")
//                        url.set("https://opensource.org/licenses/MIT")
//                    }
//                }
//                scm {
//                    connection.set("scm:git:https://github.com/JioCoders/payment_sdk_android.git")
//                    developerConnection.set("scm:git:https://github.com/JioCoders/payment_sdk_android.git")
//                    url.set("https://github.com/JioCoders/payment_sdk_android")
//                }
//
//                developers {
//                    developer {
//                        id.set("jiocoders")
//                        name.set("Jiocoders")
//                        email.set("jiocoders@gmail.com")
//                    }
//                }
//            }
//        }
//    }
//
//    // Repositories for publishing
//    repositories {
//        maven {
//            name = "sonatype"
//            url =
////                uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/") // Sonatype's Maven Central repository URL
//                uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") // Sonatype's Maven Central repository URL
//
//            credentials {
//                username = findProperty("ossrhUsername") as String?
//                password = findProperty("ossrhPassword") as String?
//            }
//        }
//    }
//    signing {
//        useInMemoryPgpKeys(
//            findProperty("signing.keyId") as String?,
//            findProperty("signing.secretKeyRingFile") as String?,
//            findProperty("signing.password") as String?
//        )
//        sign(publishing.publications["release"])
//    }
//}
// -----------old 1----------------
//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "com.jiocoders"
//            artifactId = "paymentSDK"
//            version = "1.0.0"
//
//            // The artifact: typically the AAR built by the library module.
//            artifact("$buildDir/outputs/aar/paymentSDK-release.aar")
//
//            pom {
//                name.set("paymentSDK")
//                description.set("A sample Android payment library")
//                url.set("https://github.com/JioCoders/payment_sdk_android")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("jiocoders")
//                        name.set("Jiocoders")
//                        email.set("jiocoders@gmail.com")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/JioCoders/payment_sdk_android.git")
//                    developerConnection.set("scm:git:ssh://github.com/JioCoders/payment_sdk_android.git")
//                    url.set("https://github.com/JioCoders/payment_sdk_android")
//                }
//            }
//        }
//    }
//
//    repositories {
//        maven {
//            name = "Sonatype"
//            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
//
//            credentials {
//                username = findProperty("ossrhUsername") as String?
//                password = findProperty("ossrhPassword") as String?
//            }
//        }
//    }
//}

// -----------old 2----------------

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            from(components["release"]) // Uses the release variant AAR
//
//            groupId = "com.jiocoders"   // Replace with your package
//            artifactId = "mylibrary"  // Replace with your library name
//            version = "1.0.0"
//
//            pom {
//                name.set("paymentSDK")
//                description.set("A sample Android payment library")
//                url.set("https://github.com/JioCoders/payment_sdk_android")
//                licenses {
//                    license {
//                        name.set("Apache-2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//                developers {
//                    developer {
//                        id.set("jiocoders")
//                        name.set("Jiocoders")
//                        email.set("jiocoders@gmail.com")
//                    }
//                }
//            }
//        }
//    }
//    repositories {
//        maven {
//            name = "myRepo"
//            url = uri("https://your-maven-repository.com/repository/releases")
//            credentials {
//                username = project.findProperty("mavenUsername") as String? ?: ""
//                password = project.findProperty("mavenPassword") as String? ?: ""
//            }
//        }
//    }
//}
// -----------old Local publish----------------
//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "com.jiocoders"
//            artifactId = "paymentSDK"
//            version = "1.0.0"
//
//            afterEvaluate{
//                from(components["release"])
//            }
//        }
//    }
//    repositories {
//        mavenLocal() // This pushes the AAR to ~/.m2/repository
//    }
//}

android {
    namespace = "com.jiocoders.paymentsdk"
    compileSdk = 35

    ndkVersion = "28.0.12433566"
    buildToolsVersion = "35.0.0"

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}