package com.unionpay.qrcode.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Lenovo
 */
public class UnionPayQRcodeActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union_pay_qrcode);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.unionpay_code));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView = findViewById(R.id.webview);
        webView.loadUrl("https://open.unionpay.com/ajweb/help/qrcodeFormPage");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
    }

    @Override
    public boolean
    onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            //返回上个页面
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
