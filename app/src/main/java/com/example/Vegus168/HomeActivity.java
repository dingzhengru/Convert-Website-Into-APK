package com.example.Vegus168;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        String url = "https://m.naga555.com";
        String url = "https://m.caza7.re888show.com";

        myWebView = (WebView) findViewById(R.id.myWebView);
        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.setWebViewClient(new myWebClient());
        myWebView.loadUrl(url);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        // 是否允許自動打開彈窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 是否允許多開視窗
        webSettings.setSupportMultipleWindows(true);
    }

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
//            super.onBackPressed();
        }
    }
}