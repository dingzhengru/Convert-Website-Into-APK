# Convert-Website-Into-APK
測試利用 Android Studio 的 WebView 並打包成 APK

## 參考影片

- [WebView](https://www.youtube.com/watch?v=2cWbepS1NZM)
- [Splash Screen(Splash Screen - Android Studio Tutorial) ](https://www.youtube.com/watch?v=Q0gRqbtFLcw)
- [Splash Screen(How to create Splash Screen in Android Studio | Java) ](https://www.youtube.com/watch?v=1dnM0-D5CDo)
- [Splash Screen(How to make a Splash Screen without extra Activity in Android) ](https://www.youtube.com/watch?v=rIHArmoq9f8)
- [App Icon](https://www.youtube.com/watch?v=ts98gL1JCQU)

## 工具
- [PNG to SVG](https://www.pngtosvg.com)
- [SVG to VectorDrawable](http://inloop.github.io/svg2android)

## 參考問答
- [What do I use now that Handler() is deprecated](https://stackoverflow.com/a/63851895/5134658)
- [Cannot resolve constructor (Android Intent)](https://stackoverflow.com/a/30965303/5134658)
- [Why SVG failing to load in Vector Asset Studio](https://stackoverflow.com/a/36910140/5134658)
- [Webview stuck on loading website or cloudfare check](https://stackoverflow.com/a/55449573/5134658)
- [How do I make a splash screen?](https://stackoverflow.com/a/5486970/5134658)

## keystore

- [Android Studio：Keystore 建立與管理](https://medium.com/@kentchen_tw/android-studio-keystore-%E5%BB%BA%E7%AB%8B%E8%88%87%E7%AE%A1%E7%90%86-47d4afcc6e61)
- [How can I create a keystore?](https://stackoverflow.com/questions/3997748/how-can-i-create-a-keystore)
- [Android Studio - debug keystore](https://stackoverflow.com/a/18212890/5134658)
- [I don't remember my android debug.keystore password](https://stackoverflow.com/a/42858945/5134658)

## 修改 package
- [Rename package in Android Studio](https://stackoverflow.com/a/29092698/5134658)
- [同时安装一个app的两个版本之Android Studio修改包名](https://blog.csdn.net/weixin_41552069/article/details/118571955)

## 自訂顏色
可以於 res/values/colors.xml 新增自己想要的顏色，就可用於狀態欄或其他

## 修改狀態欄顏色 (statusBarColor)
至 res/values/themes 修改 `<item name="android:statusBarColor"></item>`

## 步驟&概念

新增專案選擇 Empty Activity (MainActivity)

### WebView
參考影片照做即可

### Splash Screen

*可以將 png 直接移到 drawable 使用，不一定要用 svg, psd*

#### 製作 drawable 步驟
可以直接參考此影片: [Splash Screen(How to make a Splash Screen without extra Activity in Android) ](https://www.youtube.com/watch?v=rIHArmoq9f8)

在 res/drawable 點右鍵 => new => Drawable Resource File => 取檔名 => ok => 將內容改成下面格式 => android:drawable 改指定的圖片
```
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/naga555_splash"></item>
</layer-list>
```

#### 方法一 (推薦)
參考此影片: [Splash Screen(How to make a Splash Screen without extra Activity in Android) ](https://www.youtube.com/watch?v=rIHArmoq9f8)
參考文章: [Splash Screen in Android: The Right Way](https://medium.com/android-news/launch-screen-in-android-the-right-way-aca7e8c31f52)

res/values/themes 新增 theme
```
<style name="SplashTheme" parent="Theme.MaterialComponents.DayNight.NoActionBar">
    <item name="android:statusBarColor" tools:targetApi="l">@color/my_color</item>
    <item name="android:windowBackground">@drawable/naga555_splash</item>
</style>
```

manifests/AndroidManifest.xml 更改 theme
```
<application android:theme="@style/SplashTheme">
```

java/activity 在 super.onCreate 之前放 setTheme
```java
setTheme(R.style.SplashTheme);
```

#### 方法二

MainActivity 就當作 Splash Screen 設計，另外新增 Activity (HomeActivity)
HomeActivity 就當作主內容 (WebView)
於 MainActivity 設置延遲 (Handler) 開啟 HomeActivity，就有 Splash Screen 的效果





### App Icon

參考 App Icon 影片即可

於 res 點右鍵 => New => Image Asset => 選擇指定檔案 => 勾選 Trim 調整比例
最後於 AndroidManifest 中設置以下參數即可
```
android:icon="@mipmap/ic_launcher_test"
android:roundIcon="@mipmap/ic_launcher_test_round"
```

#### 透明 app icon (當 app icon 背景單色會很怪的時候)
主要是 icon type 選擇 Lagacy only，並且要分別創建 square & circle 的
1. 於 res 點右鍵 => New => Image Asset => icon type 選擇 Lagacy only => shape 選 square
2. 前面都跟 1 相同 => shape 選 circle (檔名後面加 _round)

### WebView 設定
``` java
myWebView = (WebView) findViewById(R.id.myWebView);
myWebView.setWebViewClient(new WebViewClient());
myWebView.loadUrl(url);
WebSettings webSettings = myWebView.getSettings();
webSettings.setJavaScriptEnabled(true);
webSettings.setAppCacheEnabled(true);
webSettings.setDomStorageEnabled(true);
```

## 修改 package
為了將所有 apk 視為不同的，且可以同時安裝

對 java/com.example.xxx 右鍵 => Refactor/Rename => Rename Package => Refactor(修改沒變，就 Build/Clean Project) => 修改 build.gradle 的 applicationId (改完後，點 sync now)