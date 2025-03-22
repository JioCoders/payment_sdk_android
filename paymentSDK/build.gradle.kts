import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { inputStream ->
        localProperties.load(inputStream)
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "com.yourcompany.sdk"
//            artifactId = "your-sdk"
//            version = "1.0.0"
//
//            // The artifact: typically the AAR built by the library module.
//            artifact("$buildDir/outputs/aar/your-sdk-release.aar")
//
//            pom {
//                name.set("Your Android SDK")
//                description.set("A description of what your SDK does.")
//                url.set("https://github.com/yourcompany/your-sdk-repo")
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
//                        id.set("your-id")
//                        name.set("Your Name")
//                        email.set("your-email@example.com")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/yourcompany/your-sdk-repo.git")
//                    developerConnection.set("scm:git:ssh://github.com/yourcompany/your-sdk-repo.git")
//                    url.set("https://github.com/yourcompany/your-sdk-repo")
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

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.jiocoders"
            artifactId = "paymentSDK"
            version = "1.0.0"

            afterEvaluate{
                from(components["release"])
            }
        }
    }
    repositories {
        mavenLocal() // This pushes the AAR to ~/.m2/repository
    }
}

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