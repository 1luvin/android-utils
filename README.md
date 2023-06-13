## Build

Add to your **root** build.gradle:

```gradle
allprojects {
   repositories {
      maven { url 'https://jitpack.io' }
   }
}
```

Add to your **module's** build.gradle:

```gradle
dependencies {
   implementation 'com.github.1luvin:android-utils:1.4'
}
```

## Usage

Initialize

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)
   Layout.initialize(this)
}
```

Example

```kotlin
val frame: FrameLayout
val view: View

frame.addView(
   view, Layout.frame(
      Layout.MATCH_PARENT, Layout.WRAP_CONTENT,
      Gravity.CENTER_VERTICAL,
      leftMargin = 20, topMargin = 0, rightMargin = 20, bottomMargin = 0
   )
)
```
