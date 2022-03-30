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

## keystore

- [Android Studio：Keystore 建立與管理](https://medium.com/@kentchen_tw/android-studio-keystore-%E5%BB%BA%E7%AB%8B%E8%88%87%E7%AE%A1%E7%90%86-47d4afcc6e61)
- [How can I create a keystore?](https://stackoverflow.com/questions/3997748/how-can-i-create-a-keystore)
- [Android Studio - debug keystore](https://stackoverflow.com/a/18212890/5134658)
- [I don't remember my android debug.keystore password](https://stackoverflow.com/a/42858945/5134658)

## 自訂顏色
可以於 res/values/colors.xml 新增自己想要的顏色，就可用於狀態欄或其他

## 修改狀態欄顏色 (statusBarColor)
至 res/values/themes 修改 `<item name="android:statusBarColor"></item>`

## 步驟&概念

新增專案選擇 Empty Activity (MainActivity)

### WebView
參考影片照做即可

### Splash Screen

MainActivity 就當作 Splash Screen 設計，另外新增 Activity (HomeActivity)
HomeActivity 就當作主內容 (WebView)
於 MainActivity 設置延遲 (Handler) 開啟 HomeActivity，就有 Splash Screen 的效果

(但此方法 png 轉 svg 圖片可能長不同，建議直接使用 svg 並照上面影片製成)
將圖片做成 Splash Screen，使用工具中 "PNG to SVG"、"SVG to VectorDrawable"
最後將 xml 放入 res/drawable，再於指定 layout 設置 android:background 即可

### App Icon

參考 App Icon 影片即可

於 res 點右鍵 => New => Image Asset => 選擇指定檔案 => 勾選 Trim 調整比例
最後於 AndroidManifest 中設置以下參數即可
```
android:icon="@mipmap/ic_launcher_test"
android:roundIcon="@mipmap/ic_launcher_test_round"
```

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