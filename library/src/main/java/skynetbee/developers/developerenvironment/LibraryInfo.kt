package skynetbee.developers.developerenvironment

/**
 * AndroidTestEngine - Developer Framework Library
 * 
 * This is a JitPack wrapper for the AndroidTestEngine library.
 * The actual library is distributed as an AAR file via GitHub releases.
 * 
 * To use this library:
 * 1. Add JitPack dependency: implementation 'com.github.monish-instinct:AndroidTestEngine:1.0.0'
 * 2. Download the AAR from: https://github.com/monish-instinct/AndroidTestEngine/releases
 * 3. Place the AAR in your app/libs/ directory
 * 4. Add: implementation files('libs/developerenvironment-1.0.0.aar')
 * 
 * This wrapper automatically includes all required dependencies.
 */
object LibraryInfo {
    const val VERSION = "1.0.0"
    const val NAME = "AndroidTestEngine - Developer Framework Library"
    const val DOWNLOAD_URL = "https://github.com/monish-instinct/AndroidTestEngine/releases/download/v1.0.0/developerenvironment-1.0.0.aar"
    
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
            
            Download the full AAR from: $DOWNLOAD_URL
        """.trimIndent()
    }
}
