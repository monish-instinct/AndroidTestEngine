package skynetbee.developers.developerenvironment

/**
 * AndroidTestEngine - Developer Framework Library
 * 
 * This is a JitPack wrapper that automatically downloads and includes the AndroidTestEngine library.
 * 
 * To use this library:
 * Simply add: implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
 * 
 * This wrapper automatically:
 * - Downloads the AAR from GitHub releases
 * - Includes all required dependencies
 * - Makes everything available to your project
 * 
 * No manual downloads or libs folder management needed!
 * 
 * Compatibility:
 * - Min SDK: 26 (Android 8.0)
 * - Target SDK: 35 (Android 15) 
 * - Compile SDK: 34-35
 * - Gradle: 8.0+
 * - AGP: 8.0+
 * - Kotlin: 1.9.0+
 */
object LibraryInfo {
    const val VERSION = "1.0.1"
    const val NAME = "AndroidTestEngine - Developer Framework Library"
    const val DOWNLOAD_URL = "https://github.com/monish-instinct/AndroidTestEngine/releases/download/v1.0.1/developerenvironment-1.0.0.aar"
    
    // Version compatibility constants
    const val MIN_SDK = 26
    const val TARGET_SDK = 34
    const val COMPILE_SDK_MIN = 34
    const val COMPILE_SDK_MAX = 34
    
    /**
     * Check if the project configuration is compatible with this library
     */
    fun checkCompatibility(compileSdk: Int, targetSdk: Int, minSdk: Int = 0): Boolean {
        return compileSdk >= COMPILE_SDK_MIN && 
               compileSdk <= COMPILE_SDK_MAX && 
               targetSdk >= MIN_SDK && 
               minSdk >= MIN_SDK
    }
    
    fun getLibraryInfo(): String {
        return """
            $NAME
            Version: $VERSION
            
            This library provides:
            - Smart alerts and dialog systems
            - HTML encapsulation components  
            - Chart and graph components
            - Database utilities and generators
            - File upload/download functionality
            - Comprehensive Material 3 UI components
            
            Compatibility:
            - Min SDK: $MIN_SDK+ (Android 8.0+)
            - Target SDK: $TARGET_SDK (Android 15)
            - Compile SDK: $COMPILE_SDK_MIN-$COMPILE_SDK_MAX
            - Gradle: 8.0+, AGP: 8.0+, Kotlin: 1.9.0+
            
            Download the full AAR from: $DOWNLOAD_URL
        """.trimIndent()
    }
}
