package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DeptWebsite extends AppCompatActivity {

    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept_website);
        webView1 = (WebView) findViewById(R.id.webview1);

        webView1.setWebViewClient(new WebViewClient());
        webView1.loadUrl("http://cse.just.edu.bd/");

        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()) {
            webView1.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
