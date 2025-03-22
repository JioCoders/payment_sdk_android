# PaymentSDK

[![Maven Central](https://img.shields.io/maven-central/v/com.jiocoders.paymentsdk)](https://search.maven.org/artifact/com.jiocoders.paymentsdk)

PaymentSDK is an Android library that provides seamless payment integration for your application.

## Installation

### Using Gradle
To use this library in your Android project, add the following dependency in your `build.gradle.kts` (Kotlin DSL) or `build.gradle` (Groovy):

```kotlin
dependencies {
    implementation("com.jiocoders:paymentSDK:1.0.0")
}
```

or

```groovy
dependencies {
    implementation 'com.jiocoders:paymentSDK:1.0.0'
}
```

Make sure you have Maven Central or your custom Maven repository in `settings.gradle` or `build.gradle`:

```kotlin
repositories {
    mavenCentral()
}
```

## Usage

To use PaymentSDK in your project, follow these steps:

```kotlin
import com.jiocoders.paymentsdk.PaymentSDK

val paymentSDK = PaymentSDK()
paymentSDK.initiatePayment(amount = 100.0, currency = "INR")
```

## Publishing the AAR to Maven

To publish the AAR to a local Maven repository, run:

```sh
./gradlew publishToMavenLocal
```

To publish to a remote repository (e.g., Nexus, JFrog Artifactory), ensure you have configured authentication in `gradle.properties`:

```properties
mavenUsername=your-username
mavenPassword=your-password
```

Then, publish using:

```sh
./gradlew publish
```

## License

This library is licensed under the Apache-2.0 License - see the [LICENSE](LICENSE) file for details.

