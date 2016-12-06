package com.view.john.htmlandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    ArrayList<String> mList;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.test_webv);
        mListView = (ListView) findViewById(R.id.listview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JsMethod(MainActivity.this),"test");
        mWebView.loadUrl("file:///android_asset/test.html");

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
               view.loadUrl(request.toString());
                return true;
            }
        });
        mList.add("file:///android_asset/test1.html");
        mList.add("file:///android_asset/test2.html");
        mList.add("file:///android_asset/test3.html");
        mList.add("file:///android_asset/test4.html");
        mList.add("file:///android_asset/test5.html");
        mList.add("file:///android_asset/test6.html");
        WebViewAdapter mAdapter = new WebViewAdapter(MainActivity.this,mList);
        mListView.setAdapter(mAdapter);

    }
    class JsFunction{
        @JavascriptInterface
        public void hello(String msg){//对应js中xxx.hello("")
            Log.e("webview","hello");
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
        }
    }


}
