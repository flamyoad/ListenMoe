@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlinSerializationPlugin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.apolloGraphql)
}

val appNamespace = "com.flamyoad.listenmoe"

android {
    namespace = appNamespace
    compileSdk = 34

    defaultConfig {
        applicationId = "com.flamyoad.listenmoe"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }
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
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    apollo {
        service("service") {
            packageName.set(appNamespace)
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar)

    implementation(libs.core.ktx)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.coroutines)
    implementation(libs.kotlinxSerializationJson)
    implementation(libs.room.runtime)
    implementation(libs.hilt.android)

    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.apollo)
    implementation(libs.bundles.ktor)

    kapt(libs.lifecycle.compiler)
    kapt(libs.hilt.compiler)
    ksp(libs.room.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)

    androidTestImplementation(libs.espresso.core)
}

kapt {
    correctErrorTypes = true
}