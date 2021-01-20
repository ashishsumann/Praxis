plugins {
  id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
  id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
  id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
  id(BuildPlugins.KOTLIN_KAPT)
}

android {
  compileSdkVersion(ProjectProperties.COMPILE_SDK)

  defaultConfig {
    minSdkVersion(ProjectProperties.MIN_SDK)
    targetSdkVersion(ProjectProperties.TARGET_SDK)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
}

dependencies {

  implementation(project(":data"))

  /*Kotlin*/
  api(Lib.Kotlin.KT_STD)
  api(Lib.Async.COROUTINES)

  /* Dependency Injection */
  api(Lib.Di.DAGGER)
  api(Lib.Di.DAGGER_ANDROID)
  kapt(Lib.Di.DAGGER_PROCESSOR)
  kapt(Lib.Di.DAGGER_COMPILER)
  kaptTest(Lib.Di.DAGGER_COMPILER)

  testApi(TestLib.JUNIT)
  testApi(TestLib.ANDROID_JUNIT)
  testApi(TestLib.CORE_TEST)
  testApi(TestLib.MOCK_WEB_SERVER)
  testApi(TestLib.ARCH_CORE)
  testApi(TestLib.ROBO_ELECTRIC)
}