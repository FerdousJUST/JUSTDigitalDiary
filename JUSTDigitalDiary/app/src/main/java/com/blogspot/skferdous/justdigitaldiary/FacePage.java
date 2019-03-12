package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FacePage extends AppCompatActivity {
    private WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_page);

        webView3 = (WebView) findViewById(R.id.webview3);

        webView3.setWebViewClient(new WebViewClient());
        webView3.loadUrl("https://www.facebook.com/justverifiedpage");

        WebSettings webSettings = webView3.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView3.canGoBack()) {
            webView3.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
