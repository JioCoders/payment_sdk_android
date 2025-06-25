//import com.vanniktech.maven.publish.SonatypeHost
//import java.io.FileInputStream
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
//    id("maven-publish")
//    id("com.vanniktech.maven.publish") version "0.33.0"
//    id("signing")
}

android {
    namespace = "com.jiocoders.mylibrary"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

//    publishing {
//        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
//        }
//    }

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
//mavenPublishing {
////    publishToMavenCentral()
////    signAllPublications()
//
//    coordinates("com.jiocoders", "mylibrary", "1.0.0")
//
//    pom {
//        name.set("Payment Library Dummy")
//        description.set("A description of what my library does.")
//        inceptionYear.set("2020")
//        url.set("https://github.com/username/payment_sdk_android/")
//        licenses {
//            license {
//                name.set("The Apache License, Version 2.0")
//                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//            }
//        }
//        developers {
//            developer {
//                id.set("jiocoders")
//                name.set("Jio Coders")
//                url.set("https://github.com/jiocoders/")
//            }
//        }
//        scm {
//            url.set("https://github.com/jiocoders/payment_sdk_android/")
//            connection.set("scm:git:git://github.com/jiocoders/payment_sdk_android.git")
//            developerConnection.set("scm:git:ssh://git@github.com/jiocoders/payment_sdk_android.git")
//        }
//    }
//    signing {
//        useInMemoryPgpKeys(
//            findProperty("signing.keyId") as String,
//            findProperty("signing.secretKeyRingFile") as String,
//            findProperty("signing.password") as String
//        )
//        sign(publishing.publications)
//    }
//}

// todo: 21 June 2025 -----------------updated method-------------
//group = "com.jiocoders"
//version = "1.0.0"
//
//afterEvaluate {
//    println("Available components: ${components.names}")
//    publishing {
//        publications {
//            create<MavenPublication>("release") {
//                // ✅ Use default for Android libraries
//                // ✅ For Android library, use 'release' variant component if you define it in `android { publishing { ... } }`
//                from(components.findByName("release") ?: error("Release component not found"))
//
//                groupId = "com.jiocoders"
//                artifactId = "paymentSDK"
//                version = "1.0.0"
//
//                pom {
//                    name.set("jiocoders")
//                    description.set("A basic Android Kotlin payment SDK")
//                    url.set("https://github.com/JioCoders/payment_sdk_android")
//
//                    licenses {
//                        license {
//                            name.set("The Apache License, Version 2.0")
//                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                        }
//                    }
//
//                    developers {
//                        developer {
//                            id.set("jiocoders")
//                            name.set("Jio Coders")
//                            email.set("jiocoders@gmail.com")
//                        }
//                    }
//
//                    scm {
//                        connection.set("scm:git:git://github.com/jiocoders/payment_sdk_android.git")
//                        developerConnection.set("scm:git:ssh://github.com/jiocoders/payment_sdk_android.git")
//                        url.set("https://github.com/jiocoders/payment_sdk_android")
//                    }
//                }
//            }
//        }
//
//        repositories {
//            maven {
//                name = "sonatype"
//                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
//                credentials {
//                    username = project.findProperty("ossrhUsername") as String
//                    password = project.findProperty("ossrhPassword") as String
////                    username = providers.gradleProperty("ossrhUsername").orNull ?: System.getenv("OSSRH_USERNAME")
////                    password = providers.gradleProperty("ossrhPassword").orNull ?: System.getenv("OSSRH_PASSWORD")
//                }
//            }
//        }
//    }
//
//    signing{
////        useGpgCmd() // use system-installed GPG
//        useInMemoryPgpKeys(
////            localProperties["signing.keyId"].toString(),
////            File(localProperties["signing.secretKeyRingFile"].toString()).readText(),
////            localProperties["signing.password"].toString()
//
//            findProperty("signing.keyId") as String?,
//            findProperty("signing.secretKeyRingFile") as String?,
//            findProperty("signing.password") as String
//        )
//        sign(publishing.publications["release"])
//    }
//}

// todo: 21 June 2025 -----------------updated method-------------

// todo: 28 Mar 2025 -----------------latest method-------------
//mavenPublishing {
//    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
//
//    signAllPublications()
//
//    coordinates("com.jiocoders", "paymentSDK", "1.0.0")
//
//    pom {
//        name = "Basic Payment library"
//        description = "A basic android kotlin payment library."
//        inceptionYear = "2025"
//        url = "https://github.com/JioCoders/payment_sdk_android/"
//        licenses {
//            license {
//                name = "The Apache License, Version 2.0"
//                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
//                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
//            }
//        }
//        developers {
//            developer {
//                id = "jiocoders"
//                name = "Kotlin Developer Advocate"
//                url = "https://github.com/JioCoders/"
//            }
//        }
//        scm {
//            url = "https://github.com/JioCoders/payment_sdk_android/"
//            connection = "scm:git:git://github.com/JioCoders/payment_sdk_android.git"
//            developerConnection = "scm:git:ssh://git@github.com/JioCoders/payment_sdk_android.git"
//        }
//    }
//    signing{
//        useInMemoryPgpKeys(
////            findProperty("signing.keyId") as String?,
////            findProperty("signing.secretKeyRingFile") as String?,
////            findProperty("signing.password") as String?
//            localProperties["signing.keyId"].toString(),
//            File(localProperties["signing.secretKeyRingFile"].toString()).readText(),
//            localProperties["signing.password"].toString()
//        )
//    }
//}
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

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}