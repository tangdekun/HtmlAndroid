package com.view.john.htmlandroid;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by John on 2016/12/6.
 */

public class JsMethod {
    Context context;
    public JsMethod(Context context){
        this.context = context;

    }
//    @JavascriptInterface
//    public void hello(String msg){
//        Toast.makeText(context,msg,Toast.LENGTH_LONG);
//    }

    @JavascriptInterface
    public void hello(String msg){//对应js中xxx.hello("")
        Log.e("webview","hello");
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
