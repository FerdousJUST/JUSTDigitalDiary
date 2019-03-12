package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class YouPage extends AppCompatActivity {
    private WebView webView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_page);


        webView4 = (WebView) findViewById(R.id.webview4);

        webView4.setWebViewClient(new WebViewClient());
        webView4.loadUrl("https://just.edu.bd/youtube");
        WebSettings webSettings = webView4.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView4.canGoBack()) {
            webView4.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
