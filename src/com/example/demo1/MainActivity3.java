package com.example.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		
		
			Intent intent = getIntent();
			String	list = intent.getStringExtra("link");
					
			WebView webview = (WebView)findViewById(R.id.webView1);
	        webview.getSettings().setJavaScriptEnabled(true); 
            webview .loadUrl("file:///android_asset/"+list);

	    }

}
