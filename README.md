# AndroidTestEngine - Developer Framework Library

A comprehensive Android library providing powerful development tools and UI components for Android applications. This library includes various features like smart alerts, HTML encapsulation components, database utilities, and more.

## 📦 Installation

### Step 1: Add JitPack Repository

Add the JitPack repository to your project's `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line
    }
}
```

**OR** if you're using an older project structure, add to your root `build.gradle`:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line
    }
}
```

### Step 2: Add the Library Dependency

**🚀 Super Easy Method (Fully Automatic)**

Simply add this **single line** to your app's `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
}
```

**That's it!** ✨ No manual downloads, no libs folder, no additional dependencies needed!

> ✅ **What happens automatically:**
> - JitPack builds the library wrapper
> - Downloads the AAR from GitHub releases
> - Includes all required dependencies
> - Makes everything available to your project

**Method 2: Manual AAR + Dependencies (Alternative)**

If you prefer not to use JitPack:

1. Download `developerenvironment-1.0.0.aar` from [GitHub Releases](https://github.com/monish-instinct/AndroidTestEngine/releases)
2. Place it in your `app/libs/` directory
3. Add ALL dependencies manually:

```gradle
dependencies {
    implementation files('libs/developerenvironment-1.0.0.aar')
    
    // Core dependencies (you must add these manually)
    implementation 'androidx.core:core-ktx:1.16.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.9.1'
    implementation 'androidx.appcompat:appcompat:1.7.0'
    implementation platform('androidx.compose:compose-bom:2025.06.00')
    implementation 'androidx.compose.ui:ui:1.8.2'
    implementation 'androidx.compose.material3:material3:1.1.0'
    implementation 'androidx.activity:activity-compose:1.10.1'
    implementation 'androidx.compose.ui:ui-tooling:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout-compose:1.1.1'
    implementation 'com.google.accompanist:accompanist-systemuicontroller:0.36.0'
    implementation 'androidx.navigation:navigation-compose:2.7.4'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1'
    implementation 'androidx.media3:media3-ui:1.3.0'
    implementation 'androidx.media3:media3-exoplayer:1.3.0'
    implementation 'androidx.compose.material:material-icons-extended:1.4.0'
    implementation 'io.coil-kt:coil-compose:2.4.0'
    implementation 'com.airbnb.android:lottie-compose:6.0.0'
    implementation 'androidx.sqlite:sqlite-ktx:2.2.0'
    implementation 'com.squareup.okhttp3:okhttp:4.11.0'
    implementation 'com.itextpdf:itext7-core:9.2.0'
    implementation 'org.apache.poi:poi-ooxml:5.2.3'
    implementation 'org.apache.commons:commons-lang3:3.13.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'io.reactivex.rxjava3:rxjava:3.1.7'
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.2'
    implementation "com.google.accompanist:accompanist-flowlayout:0.30.1"
    implementation "net.zetetic:android-database-sqlcipher:4.5.4"
    implementation 'com.razorpay:checkout:1.6.33'
}
```

## 🔧 Setup Requirements

### Minimum Requirements
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 34-35 (Android 14-15)
- **Java Version**: 11+ (Recommended: 17+)
- **Gradle**: 8.0+ (Recommended: 8.4+)
- **AGP**: 8.0+ (Recommended: 8.3.2+)
- **Kotlin**: 1.9.0+ (Recommended: 2.0.0+)

### Required Dependencies
The library automatically includes these dependencies:
- AndroidX Core KTX
- Jetpack Compose BOM
- Material 3 Components
- Activity Compose
- Lifecycle Runtime

### Permissions
Add these permissions to your `AndroidManifest.xml` if you plan to use related features:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```

## 🚀 Quick Start

### Initialize the Engine

```kotlin
import skynetbee.developers.developerenvironment.DeveloperFramework.EngineStarter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize the Developer Engine
        EngineStarter.initialize(this)
        
        setContent {
            // Your compose content
        }
    }
}
```

### Using Smart Alerts

```kotlin
import skynetbee.developers.developerenvironment.DeveloperFramework.SweetAlerts.smartalert

// Show success alert
smartalert(
    context = context,
    title = "Success!",
    message = "Operation completed successfully",
    type = "success"
)

// Show error alert
smartalert(
    context = context,
    title = "Error",
    message = "Something went wrong",
    type = "error"
)
```

### Using HTML Components

```kotlin
import skynetbee.developers.developerenvironment.DeveloperFramework.HTMLEncapsules.SmartButton

@Composable
fun MyScreen() {
    SmartButton(
        text = "Click Me",
        onClick = { /* Handle click */ }
    )
}
```

## 📚 Available Components

### UI Components
- **SmartButton**: Enhanced button with various styles
- **SmartTables**: Advanced table components
- **RatingStars**: Star rating component
- **FileUploader**: File upload functionality
- **ImageUploader**: Image upload with preview
- **VideoUpload**: Video upload and playback
- **AudioUploader**: Audio recording and playback

### Alerts & Dialogs
- **SmartAlert**: Beautiful alert dialogs
- **SmartConfirm**: Confirmation dialogs
- **SmartPrompt**: Input prompt dialogs

### Charts & Graphs
- **BarGraph**: Bar chart component
- **LineGraphs**: Various line chart types (1-5 lines)
- **DoubleDoughnutChart**: Doughnut chart component

### Utilities
- **Database Tools**: SQLite helpers and connection managers
- **PDF Generator**: Generate PDF documents
- **Excel Tools**: Read/write Excel files
- **Validators**: Input validation utilities
- **Quick Access**: Common UI patterns

## 🛠️ Advanced Configuration

### Custom Theme Integration

The library respects your app's Material 3 theme. To customize:

```kotlin
@Composable
fun MyApp() {
    MyAppTheme {
        // Library components will automatically use your theme colors
        SmartButton(text = "Themed Button")
    }
}
```

### Database Configuration

```kotlin
import skynetbee.developers.developerenvironment.NeuralEngine.Database.SQLizer

// Initialize database
val dbHelper = SQLizer(context, "myapp.db", 1)
```

## 📖 Documentation

### Method Reference

Most components follow this pattern:
- Compose-based UI components
- Callback-driven interactions
- Material 3 design principles
- Dark/Light theme support

### Example Project Structure

```
app/
├── src/main/java/
│   └── com/yourcompany/yourapp/
│       ├── MainActivity.kt
│       ├── ui/
│       │   └── screens/
│       └── data/
└── build.gradle
```

## 🔍 Troubleshooting

### Common Issues

1. **Build Error**: Ensure you're using the correct Kotlin version (2.1.21+)
2. **Theme Issues**: Make sure you're using Material 3 theme
3. **Permission Errors**: Add required permissions to manifest

### Support

For issues and feature requests, please contact the development team.

## 📄 License

This library is proprietary. The source code is not available publicly.

## 🏷️ Version History

- **1.0.0**: Initial release with core components and utilities

---

**Built with ❤️ by SkynetBee Developers**
