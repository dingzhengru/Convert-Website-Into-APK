# Convert-Website-Into-APK
測試利用 Android Studio 的 WebView 並打包成 APK

## 參考影片

- [WebView](https://www.youtube.com/watch?v=2cWbepS1NZM)
- [Splash Screen](https://www.youtube.com/watch?v=2cWbepS1NZM)
- [App Icon](https://www.youtube.com/watch?v=ts98gL1JCQU)

## 工具
- [PNG to SVG](https://www.pngtosvg.com)
- [SVG to VectorDrawable](http://inloop.github.io/svg2android)

## 參考問答
- [What do I use now that Handler() is deprecated](https://stackoverflow.com/a/63851895/5134658)
- [Cannot resolve constructor (Android Intent)](https://stackoverflow.com/a/30965303/5134658)
- [Why SVG failing to load in Vector Asset Studio](https://stackoverflow.com/a/36910140/5134658)


## 步驟&概念

新增專案選擇 Empty Activity (MainActivity)

### WebView
參考影片照做即可

### Splash Screen

MainActivity 就當作 Splash Screen 設計，另外新增 Activity (HomeActivity)
HomeActivity 就當作主內容 (WebView)
於 MainActivity 設置延遲 (Handler) 開啟 HomeActivity，就有 Splash Screen 的效果

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
