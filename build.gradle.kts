// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(sharedLibs.plugins.android.application) apply false
    alias(sharedLibs.plugins.kotlin.android) apply false
    alias(sharedLibs.plugins.sqldelight) apply false
}
