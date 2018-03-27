package com.zonsim.nestedscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zonsim.nestedscroll.behavior.BehaviorActivity;
import com.zonsim.nestedscroll.nestingscroll.NestedScrollActivity;
import com.zonsim.nestedscroll.touch.TouchActivity;

public class MainActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://m.17hbpx.com/html/news/detail/2158");// /2150
        
    }
    
    public void click1(View view) {
        startActivity(new Intent(this, TouchActivity.class));
        
        
    }
    
    public void click2(View view) {
        startActivity(new Intent(this, NestedScrollActivity.class));
    }
    
    public void click3(View view) {
        startActivity(new Intent(this, BehaviorActivity.class));
    }
    
    public void click(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }
}
