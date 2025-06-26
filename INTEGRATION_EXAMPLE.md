# Integration Example

This guide shows you how to integrate the AndroidTestEngine library into your Android project.

## Complete Integration Steps

### 1. Add JitPack Repository

Add JitPack to your project's `settings.gradle` file:

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

### 2. Add Single Dependency

Add this **one line** to your app's `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
}
```

**That's it!** No manual downloads, no libs folder needed!

### 3. Full Example app/build.gradle

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

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    // AndroidTestEngine Library - ONE LINE DOES EVERYTHING! 🚀
    implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
    
    // That's it! All dependencies are automatically included!
    // No need to add 30+ dependencies manually
}
```

### 4. Add Permissions to AndroidManifest.xml

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    
    <!-- Required permissions for library features -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/Theme.YourApp">
        
        <!-- Your activities -->
        
    </application>
</manifest>
```

### 5. Initialize in MainActivity

```kotlin
package com.yourcompany.yourapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import skynetbee.developers.developerenvironment.DeveloperFramework.EngineStarter
import com.yourcompany.yourapp.ui.theme.YourAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize the Developer Engine
        EngineStarter.initialize(this)
        
        setContent {
            YourAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
```

### 6. Use Library Components

```kotlin
package com.yourcompany.yourapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import skynetbee.developers.developerenvironment.DeveloperFramework.SweetAlerts.smartalert
import skynetbee.developers.developerenvironment.DeveloperFramework.HTMLEncapsules.SmartButton

@Composable
fun MainScreen() {
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        Text(
            text = "AndroidTestEngine Demo",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Using SmartButton from the library
        SmartButton(
            text = "Show Success Alert",
            onClick = {
                smartalert(
                    context = context,
                    title = "Success!",
                    message = "Library is working perfectly!",
                    type = "success"
                )
            }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        SmartButton(
            text = "Show Error Alert",
            onClick = {
                smartalert(
                    context = context,
                    title = "Error",
                    message = "This is an error alert example",
                    type = "error"
                )
            }
        )
    }
}
```

### 7. Build and Run

1. Sync your project with Gradle files
2. Build and run your application
3. Test the library components

## Troubleshooting

### Common Issues:

1. **Build errors**: Make sure JitPack repository is added to settings.gradle
2. **Runtime crashes**: Ensure you've called `EngineStarter.initialize(this)` in your MainActivity
3. **Download issues**: Check internet connection during first build (AAR downloads automatically)
4. **JitPack timeout**: If build times out, try again - JitPack builds on first request

### Version Compatibility:
- Android Studio: Arctic Fox or newer
- Gradle: 7.0+
- Kotlin: 1.9.0+
- Java: 11+

## Next Steps

Explore other components available in the library:
- Smart Tables
- Chart Components (Bar graphs, Line graphs, Doughnut charts)
- File Upload/Download functionality
- Database utilities
- PDF and Excel generators

Check the main README.md for complete API documentation.
