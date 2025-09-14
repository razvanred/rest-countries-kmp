# 🇵🇪 REST Countries

[![CI](https://github.com/razvanred/rest-countries-mobile/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/razvanred/rest-countries-mobile/actions/workflows/ci.yml)
[![ktlint](https://img.shields.io/badge/ktlint%20code--style-%E2%9D%A4-FF4081)](https://pinterest.github.io/ktlint/)

The _one and only_ mobile application that displays the countries from the [REST Countries API](https://restcountries.com/).

<div align="center" style="margin:auto;vertical-align:middle;">
   <picture>
      <source media="(prefers-color-scheme: dark)" srcset="docs/assets/pixel9a-dark-countries-screen.png" />
      <source media="(prefers-color-scheme: light)" srcset="docs/assets/pixel9a-light-countries-screen.png" />
      <img alt="Device screenshot of the Countries screen on a Pixel 9A" src="docs/assets/pixel9a-light-countries-screen.png" width="160" hspace="10" />
   </picture>
   <picture>
      <source media="(prefers-color-scheme: dark)" srcset="docs/assets/pixel9a-dark-details-screen.png" />
      <source media="(prefers-color-scheme: light)" srcset="docs/assets/pixel9a-light-details-screen.png" />
      <img alt='Device screenshot of the "Republic of Croatia" country detail screen on a Pixel 9A' src="docs/assets/pixel9a-light-details-screen.png" width="160" hspace="10" />
   </picture>
   <picture>
      <source media="(prefers-color-scheme: dark)" srcset="docs/assets/iphone16-dark-countries-screen.png" />
      <source media="(prefers-color-scheme: light)" srcset="docs/assets/iphone16-light-countries-screen.png" />
      <img alt="Device screenshot of the Countries screen on an iPhone 16" src="docs/assets/iphone16-light-countries-screen.png" width="165" hspace="10" />
   </picture>
   <picture>
      <source media="(prefers-color-scheme: dark)" srcset="docs/assets/iphone16-dark-details-screen.png" />
      <source media="(prefers-color-scheme: light)" srcset="docs/assets/iphone16-light-details-screen.png" />
      <img alt='Device screenshot of the "Republic of Croatia" country detail screen on an iPhone 16' src="docs/assets/iphone16-light-details-screen.png" width="165" hspace="10" />
   </picture>
</div>

## 🌟 Tech stack

### 🏛️ A Multiplatform foundation

- 🛂 Separated Gradle subprojects for each data layer
- 💉 **Dependency Injection** through [Koin](https://github.com/InsertKoinIO/koin)
- 🌊 **Async calls and Reactive Flows** through [Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- 🌍 **Remote fetching** from the REST API through [Ktor Client](https://github.com/ktorio/ktor)
- 📄 **Data serialization** through [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
- 🍔 **Caching on a local database** with [AndroidX Room](https://developer.android.com/jetpack/androidx/releases/room)
- 🗂️ **Different data layer handling** through [Store](https://github.com/MobileNativeFoundation/Store)
- ❗️ Network errors clearly propagated through layers and displayed to the user
- 🧪 **Unit tests** using:
  - [Kotlin Test](https://kotlinlang.org/api/core/kotlin-test/)
  - [AssertK](https://github.com/willowtreeapps/assertk)
  - [Turbine](https://github.com/cashapp/turbine)
- 🧩 **Shared build logic** between subprojects through [convention plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html)

### 🤖 Android application

- 🎨 **UI** implemented using [Jetpack Compose](https://developer.android.com/compose), with a separated Design System module
- 🖼️ **Image loading** through [Coil](https://github.com/coil-kt/coil)
- 📸 **Screenshot testing** using [Paparazzi](https://github.com/cashapp/paparazzi)
- 🧪 **Unit tests** using [JUnit4](https://github.com/junit-team/junit4)
- ☕️ [Instrumented tests](https://developer.android.com/training/testing/instrumented-tests) with:
  - [AndroidX Compose Testing libraries](https://developer.android.com/develop/ui/compose/testing)
  - [Espresso](https://developer.android.com/training/testing/espresso)

### 🍎 iOS application

- 🎨 **UI** implemented using [SwiftUI](https://developer.apple.com/swiftui/)
- 💉 **Dependency Injection** through [Factory](https://github.com/hmlongco/Factory)
- 📦 **Remote dependencies management** through [Swift Package Manager](https://github.com/swiftlang/swift-package-manager)
- 🧰 **Xcode configuration files management** through [Tuist](https://github.com/tuist/tuist)

## 🚀 Get started

For the **Android** app, just open the root folder with [Android Studio](https://developer.android.com/studio), and make sure you are using the proper version by checking the [Android Gradle plugin and Android Studio compatibility](https://developer.android.com/build/releases/gradle-plugin#android_gradle_plugin_and_android_studio_compatibility) matrix.

For **iOS**, as mentioned above, we are using [Tuist](https://github.com/tuist/tuist) to generate the Xcode project file. In order to open the project, run the following commands from the project root folder:

```bash
cd ios-app
mise trust # Trusts the defined packages; make sure you have Mise En Place installed on your machine
mise install # Installs the needed packages for the environment
tuist install # Downloads the needed dependencies for the app project
tuist generate # Opens the project on Xcode
```

To edit the project configuration, simply run from the `/ios-app` path:

```bash
tuist edit
```

## ✏️ Want to contribute?

The following steps are recommended if you want to open a new PR to bring your contribution.

### 🧼 Format your code

If you want to contribute to the **Android** and/or **Kotlin Multiplatform** code, run the following command from the project root folder:

```bash
./gradlew spotlessApply # or gradlew.bat spotlessApply on Windows
```

For the **iOS** side, run from the project root folder:

```bash
cd ios-app
mise install # Fetches SwiftFormat
swiftformat .
```

### 🪝 Configure Git Hooks

To check the code formatting before committing your working copy, you can locally configure the Git Hooks available from this repository:

```bash
git config --local core.hooksPath .githooks
```

## 💟 Huge thanks to…

- [Chris Banes](https://chrisbanes.me/), with his [tivi.app](https://github.com/chrisbanes/tivi): his project not only taught me during the years
    about the Android development, but also shaped me as a developer in a general way
- Although I never participated to this event, the [DroidKaigi](https://github.com/DroidKaigi) conference applications helped me
    during the early stages of my journey, and I am deeply grateful for the hard work the team is putting every year
- [Now in Android](https://github.com/android/nowinandroid): _A fully functional Android app built entirely with Kotlin and Jetpack Compose_
- [Clean Architecture for SwiftUI + Combine](https://github.com/nalexn/clean-architecture-swiftui/): _SwiftUI sample app using Clean Architecture_
- All the contributors of the mentioned libraries
- [REST Countries API project](https://gitlab.com/restcountries/restcountries)
