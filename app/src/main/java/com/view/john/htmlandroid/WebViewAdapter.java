package com.view.john.htmlandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by John on 2016/12/6.
 */

public class WebViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mList;
    public WebViewAdapter(Context context,ArrayList<String> mList){
        this.context = context;
        this.mList = mList;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_webview,null);
        WebView mWebView = (WebView) view.findViewById(R.id.item_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JsMethod(context),"test");
        mWebView.loadUrl(mList.get(i));
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
        return view;
    }
}
