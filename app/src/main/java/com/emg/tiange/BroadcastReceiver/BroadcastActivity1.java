package com.emg.tiange.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emg.tiange.R;

public class BroadcastActivity1 extends AppCompatActivity {

	private Button mBtnTurn;
	private TextView mTxvTitle;
	MyReceiver myReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast1);
		mBtnTurn = findViewById(R.id.btn_turn);
		mTxvTitle = findViewById(R.id.tx_show);
		mBtnTurn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BroadcastActivity1.this,BroadcastActivity2.class);
				startActivity(intent);
				myReceiver = new MyReceiver();
				//添加过滤器
				IntentFilter intentFilter = new IntentFilter();
				intentFilter.addAction("com.emg.helloword");

				//注册广播监听器
				registerReceiver(myReceiver,intentFilter);
			}
		});
	}

	public class MyReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("com.emg.helloword")) { //获取广播行为，是否接收
				mTxvTitle.setText(intent.getAction());
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(myReceiver);
	}
}
