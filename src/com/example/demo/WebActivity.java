package com.example.demo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class WebActivity extends Activity{
	private WebView webView;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			webView=(WebView) findViewById(R.id.webview);
			//加载asset中的资源
			webView.loadUrl("file:///android_asset/js.html");
			//webView使用JavaScript的
			WebSettings settings=webView.getSettings();
			//加载js的代码
			settings.setJavaScriptEnabled(true);
			/**
			 * @param obj Java对象注入到这个WebView的JavaScript
			 * @param name 揭露对象在JavaScript中使用的名称
			 */
			webView.addJavascriptInterface(new WebAppInterface(this), "Android");
		}
		public class WebAppInterface {
		    Context mContext;

		    /** Instantiate the interface and set the context */
		    WebAppInterface(Context c) {
		        mContext = c;
		    }

		    /** Show a toast from the web page */
		    /**Android官网强烈推荐
		     * If you've set your targetSdkVersion to 17 or higher, you must add the @JavascriptInterface
		     * 如果你的sdk在17获取17以上的话必须在方法的前面加上@JavascriptInterface。不然js的代码不能访问;
		     * @param toast
		     */
		    @JavascriptInterface
		    public void showToast(String toast) {
		        Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
		    }
		}
}

