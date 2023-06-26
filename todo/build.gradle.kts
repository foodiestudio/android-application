@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(sharedLibs.plugins.android.application)
    alias(sharedLibs.plugins.kotlin.android)
}

android {
    // TODO: rename
    namespace = "com.example.todo"
    compileSdk = 33

    defaultConfig {
        // TODO: rename
        applicationId = "com.example.todo"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = sharedLibs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(platform(sharedLibs.compose.bom))
    implementation(platform(sharedLibs.okhttp.bom))
    androidTestImplementation(platform(sharedLibs.compose.bom))

    implementation(sharedLibs.bundles.jetpack)
    implementation(sharedLibs.bundles.compose)
    implementation(sharedLibs.logcat)
    debugImplementation(sharedLibs.bundles.debug)

    testImplementation(sharedLibs.junit)

//    androidTestImplementation(libs.runner)
//    androidTestImplementation(libs.espresso.core)
}