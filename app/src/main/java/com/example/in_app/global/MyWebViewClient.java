package com.example.in_app.global;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private final URL url = new URL();

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (this.url.name.equals(request.getUrl().getHost())) {
            // This is your website, so don't override. Let your WebView load the
            // page.
            return false;
        }
        // Otherwise, the link isn't for a page on your site, so launch another
        // Activity that handles URLs.
//        Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
//        startActivity(intent);
        return true;
    }

}
