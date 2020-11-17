package com.emg.tiange.NetworkCom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.R;

public class NetworkActivity extends AppCompatActivity {

	private Button mBtnHttpConnect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);

		mBtnHttpConnect = findViewById(R.id.btn_http_connect);
	}

	void clickListener() {
		OnClick onClick = new OnClick();
		mBtnHttpConnect.setOnClickListener(onClick);
	}

	private class OnClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
				case R.id.btn_http_connect:
					intent = new Intent (NetworkActivity.this,HttpUrlConnectActivity.class);
					startActivity(intent);
					break;
			}
		}
	}
}
