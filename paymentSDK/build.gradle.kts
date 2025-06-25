import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
    id("signing")
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { inputStream ->
        localProperties.load(inputStream)
    }
}

android {
    namespace = "com.jiocoders"
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

    buildFeatures {
        buildConfig = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
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

// 🔁 Publishing block must come *after* Android config
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.jiocoders"
                artifactId = "PaymentSDK"
                version = "1.0.1"

                // ❗️This must be delayed
                from(components["release"])

                pom {
                    name.set("PaymentSDK")
                    description.set("PaymentSDK: Library for Android Application")
                    url.set("https://github.com/jiocoders/payment_sdk_android.git")
                    packaging = "aar"
                    inceptionYear.set("2025")

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set("JioCoders")
                            name.set("Jio Coders")
                            email.set("jiocoders@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git@github.com:jiocoders/payment_sdk_android")
                        developerConnection.set("scm:git@github.com:jiocoders/payment_sdk_android.git")
                        url.set("https://github.com/jiocoders/payment_sdk_android.git")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "sonatype"
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = localProperties["ossrhUsername"]?.toString()
                    password = localProperties["ossrhPassword"]?.toString()
                }
            }
        }
    }

    signing {
        useInMemoryPgpKeys(
            localProperties["signing.keyId"]?.toString(),
            File(localProperties["signing.secretKeyRingFile"].toString()).readText(),
            localProperties["signing.password"]?.toString()
        )
        sign(publishing.publications["release"])
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
