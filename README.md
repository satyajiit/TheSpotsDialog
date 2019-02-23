# The Spots  progress dialog

[![PlayStore](https://img.shields.io/badge/Play%20Store-demo-blue.svg)](#)
&nbsp;&nbsp;
[![](https://jitpack.io/v/satyajiit/TheSpotsDialog.svg)](https://jitpack.io/#satyajiit/TheSpotsDialog)

The Android AlertDialog with moving spots progress indicator packed as android library.

<img src="/screenshots/gif1.gif"/>

===========

### Usage

The library available in jitPack. You can get it using:
```groovy
allprojects {
repositories {
		...
		maven { url 'https://jitpack.io' }
		}
	}
dependencies {
     implementation 'com.github.satyajiit:TheSpotsDialog:0.94'
}
```

**Note:** The library requires minimum API level 15.

[TheSpotsDialog](/Library/src/main/java/com/satyajit/thespotsdialog/SpotsDialog.java) class is an inheritor of a AlertDialog class. You can use it just like simple [AlertDialog](http://developer.android.com/reference/android/app/AlertDialog.html). For example:
```kotlin
val dialog: AlertDialog = SpotsDialog.Builder().setContext(context).build()
...
dialog.show()
...
dialog.dismiss()
```

### Customization

For dialog customization of dialog, like message and cancel listener, use `SpotsDialog.Builder` methods.

```kotlin
val dialog: AlertDialog = SpotsDialog.Builder()
    .setContext(this)
    .setMessage(R.string.custom_title)
    .setCancelable(false)
    ...
    .build()
    .apply { 
        show() 
    }
...
dialog.dismiss()
```

For adding Custom Typeface (JAVA):

```java
val dialog: AlertDialog = SpotsDialog.Builder()
    .setContext(this)
    .setMessage(R.string.custom_title)
    .setCancelable(false)
    .setTypeface(typeface) //typeface of your own
    ...
    .build()
    .apply { 
        show() 
    }
...
dialog.dismiss()
```
Result:

<img src="/screenshots/gif3.gif"/>


For changing dialogs look and feel, create style and pass it ot dialog builder:
```kotlin
val dialog: AlertDialog = SpotsDialog.Builder()
    .Builder()
    .setContext(context)
    .setTheme(R.style.Cusom)
    .build()
    .apply {
        show()
    }
```

For styling the next custom attributes provided:
* DialogTitleAppearance : style reference
* DialogTitleText : string
* DialogSpotColor : color
* DialogSpotCount : integer

**For example:**

Provide you own style resource:
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Custom" parent="android:Theme.DeviceDefault.Dialog">
        <item name="DialogTitleAppearance">@android:style/TextAppearance.Medium</item>
        <item name="DialogTitleText">With Custom Style…</item>
        <item name="DialogSpotColor">@android:color/holo_orange_dark</item>
        <item name="DialogSpotCount">4</item>
    </style>
</resources>
```

Result:

<img src="/screenshots/gif2.gif"/>


**Note:**
On the pre-lollipop devices _DialogSpotColor_ item won't work. As workaround just override color in your resources.
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="spots_dialog_color">@color/your_color_value</color>
</resources>
```


===========
### Screenshots from Sample App

<img src="/screenshots/ss1.png"  /><img src="/screenshots/ss2.png"  />

<img src="/screenshots/ss3.png"   /><img src="/screenshots/ss4.png" />


### Developed By

Satyajit Pradhan - http://satyajiit.xyz

Thanks to D-Max for the Idea.


