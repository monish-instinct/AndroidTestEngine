# AndroidTestEngine Compatibility Guide

## 📱 Supported Versions

### Android
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 35 (Android 15)

### Build Tools
- **Gradle**: 8.0+ (Recommended: 8.4+)
- **AGP**: 8.0+ (Recommended: 8.3.2+)
- **Kotlin**: 1.9.0+ (Recommended: 2.0.0+)
- **Java**: 11+ (Recommended: 17+)

### Compose
- **Compose BOM**: 2024.09.00+ (Recommended: 2025.06.00)
- **Compose Compiler**: 1.5.0+ (Recommended: 1.5.15+)

## ✅ Known Compatible Project Configurations

### Configuration 1: Latest (Recommended)
```gradle
android {
    compileSdk 35
    
    defaultConfig {
        minSdk 26
        targetSdk 35
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }
}

dependencies {
    implementation platform('androidx.compose:compose-bom:2025.06.00')
    implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
}
```

### Configuration 2: Stable
```gradle
android {
    compileSdk 34
    
    defaultConfig {
        minSdk 26
        targetSdk 34
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
}

dependencies {
    implementation platform('androidx.compose:compose-bom:2024.09.00')
    implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
}
```

## 🔧 Troubleshooting

### Common Issues & Solutions

#### 1. Build Failed - SDK Version Mismatch
**Error**: `Compile SDK version XX is higher than latest available`
**Solution**: Update your Android SDK or lower your compileSdk version to 34

#### 2. Dependency Resolution Failed
**Error**: `Could not resolve com.github.monish-instinct:AndroidTestEngine:1.0.0`
**Solution**: Ensure JitPack repository is added to your `settings.gradle.kts`:
```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

#### 3. Compose Version Conflicts
**Error**: Multiple Compose version conflicts
**Solution**: Use Compose BOM and ensure all Compose dependencies use the same version:
```gradle
implementation platform('androidx.compose:compose-bom:2025.06.00')
implementation 'androidx.compose.ui:ui'  // No version specified
implementation 'androidx.compose.material3:material3'  // No version specified
```

#### 4. Packaging Conflicts
**Error**: `Duplicate files found in META-INF/`
**Solution**: Add packaging options to your `build.gradle`:
```gradle
android {
    packaging {
        resources {
            excludes += [
                '/META-INF/{AL2.0,LGPL2.1}',
                '/META-INF/DEPENDENCIES',
                '/META-INF/NOTICE',
                '/META-INF/LICENSE'
            ]
        }
    }
}
```

#### 5. AAR Download Issues
**Error**: `Failed to download AAR`
**Solution**: Check internet connection and try again. The AAR downloads automatically from GitHub releases.

## 📋 Version History

### v1.0.0 (Current)
- Initial release
- Support for Android API 26-35
- Jetpack Compose integration
- Material 3 components
- Automatic AAR downloading via JitPack

## 🆘 Getting Help

If you encounter issues not covered in this guide:

1. Check that your project meets the minimum requirements
2. Verify JitPack repository is properly configured
3. Ensure all dependency versions are compatible
4. Try a clean build: `./gradlew clean build`

For additional support, check the [README.md](README.md) and [INTEGRATION_EXAMPLE.md](INTEGRATION_EXAMPLE.md) files.
