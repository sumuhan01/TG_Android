package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

	private WebView mWebV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		mWebV = findViewById(R.id.wv);

		mWebV.getSettings().setJavaScriptEnabled(true);
		mWebV.setWebChromeClient(new MyWebChromeClient());
		mWebV.setWebViewClient(new MyWebViewClient());
		mWebV.loadUrl("https://www.zhihu.com/hot");
	}

	//辅助WebView处理各种通知与请求事件
	class MyWebViewClient extends WebViewClient{

		//控制对新加载的Url的处理,返回true,说明主程序处理WebView不做处理,返回false意味着WebView会对其进行处理
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
			view.loadUrl(request.getUrl().toString());
			return true;
		}

		//通知主程序网页开始加载

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			Log.d("webview","onPageStarted...");
		}

		//通知主程序,网页加载完毕

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			Log.d("webview","onPageFinished...");
		}
	}

	//辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
	class MyWebChromeClient extends WebChromeClient
	{
		//当加载进度条发生改变时调用
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			super.onProgressChanged(view, newProgress);
		}

		//获得网页的标题

		@Override
		public void onReceivedTitle(WebView view, String title) {
			super.onReceivedTitle(view, title);
			setTitle(title);
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && mWebV.canGoBack()) {
			mWebV.goBack();
			return true;
		}
		return super.onKeyDown(keyCode,event);
	}
}
