package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class browse extends AppCompatActivity {

    WebView web;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        s = getIntent().getExtras().getString("str");

        web = (WebView) findViewById(R.id.web);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl(s);
        web.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {

        if (web.canGoBack()) {
            web.goBack();
        }
        else{
            Intent i = new Intent(this,MainBrowse.class);
            startActivity(i);
            setContentView(R.layout.activity_main_browse);

        }
    }
}


