# Integration Example

This guide shows you how to integrate the AndroidTestEngine library into your Android project.

## Complete Integration Steps

### 1. Download the AAR

1. Go to [GitHub Releases](https://github.com/monish-instinct/AndroidTestEngine/releases)
2. Download `developerenvironment-1.0.0.aar`
3. Create a `libs` folder in your app module if it doesn't exist
4. Place the AAR file in `app/libs/`

### 2. Project Structure
```
YourProject/
├── app/
│   ├── libs/
│   │   └── developerenvironment-1.0.0.aar  ← Place AAR here
│   ├── src/
│   └── build.gradle  ← Add dependencies here
├── build.gradle
└── settings.gradle
```

### 3. Update app/build.gradle

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
    // AndroidTestEngine Library
    implementation files('libs/developerenvironment-1.0.0.aar')
    
    // Required Core Dependencies
    implementation 'androidx.core:core-ktx:1.16.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.9.1'
    implementation 'androidx.appcompat:appcompat:1.7.0'
    implementation 'androidx.activity:activity-compose:1.10.1'
    
    // Compose BOM
    implementation platform('androidx.compose:compose-bom:2025.06.00')
    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'
    
    // Additional Required Dependencies
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

1. **Build errors**: Make sure all dependencies are added and versions match
2. **Runtime crashes**: Ensure you've called `EngineStarter.initialize(this)` in your MainActivity
3. **Missing components**: Verify the AAR file is in the correct location (`app/libs/`)

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
