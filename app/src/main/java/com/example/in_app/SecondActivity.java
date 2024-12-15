package com.example.in_app;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.in_app.global.MyWebViewClient;
import com.example.in_app.global.URL;
import com.example.in_app.global.WebAppInterface;

public class SecondActivity extends AppCompatActivity {

    WebView myWebView;
    private final URL url = new URL();
    private WebAppInterface webAppInterface = new WebAppInterface(this);
    private MyWebViewClient myWebViewClient = new MyWebViewClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        myWebView = (WebView) findViewById(R.id.second_view);
        myWebView.addJavascriptInterface(webAppInterface, "Android");
        myWebView.setWebViewClient(myWebViewClient);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(this.url.getName());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check whether the key event is the Back button and if there's history.
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it isn't the Back button or there's no web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event);
    }
}