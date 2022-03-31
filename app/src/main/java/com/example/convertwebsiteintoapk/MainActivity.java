package com.example.convertwebsiteintoapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;


import android.content.Intent;
//import android.os.Handler;
//import android.os.Looper;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://m.caza7.re888show.com";
//        String url = "https://m.bestwin99.net";
//        String url = "https://m.caesar88.org";
//        String url = "https://m.fin99.net";
//        String url = "https://m.gclubet.com";
//        String url = "https://m.lionking88.net";
//        String url = "https://m.maxplay168.com";
//        String url = "https://m.maxwin99.net";
//        String url = "https://m.jp168.org";
//        String url = "https://m.naga555.com";
//        String url = "https://m.rabbit168.com";
//        String url = "https://m.starbets99.com";
//        String url = "https://m.168vegus.com";

        myWebView = (WebView) findViewById(R.id.myWebView);
//        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new myWebClient());
        myWebView.loadUrl(url);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

//        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//        startActivity(intent);


//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }
//        }, 2000);
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
//            super.onBackPressed();
        }
    }


    public class myWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (URLUtil.isNetworkUrl(url)) {
                return false;
            }
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }
        }
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        }

//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
    }

}