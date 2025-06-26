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
