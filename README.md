# NewFlix (decompiled) – Android Studio import

This project wraps the decompiled NewFlix sources into a Gradle structure that Android Studio can open. The codebase already contains most third-party libraries as decompiled source; only minimal Gradle deps are enabled.

## Structure
- `app/src/main/java` – decompiled Java sources (includes third-party libs).
- `app/src/main/res` – resources from the APK.
- `app/src/main/assets` – assets copied from the APK.
- `app/src/main/jniLibs` – native `.so` libs from the APK.

## Build notes
- compileSdk 34, minSdk 21, targetSdk 29, appId `flix.com.vision` (matches manifest).
- MultiDex is enabled.
- No external dependencies are declared except `androidx.multidex`; add more only if you choose to replace bundled library sources with Maven artifacts to avoid duplicate classes.
- No Gradle wrapper is committed; let Android Studio generate one or run `gradle wrapper` with your installed Gradle.

## Next steps
1) Open `NewFlix-project` in Android Studio and let it download the Android SDK 34 platform.
2) Build `:app`. If you prefer using official Maven artifacts instead of decompiled library sources, add them to `app/build.gradle` and remove/ignore overlapping packages to avoid duplicate classes.
3) Sign and install the resulting APK as needed.