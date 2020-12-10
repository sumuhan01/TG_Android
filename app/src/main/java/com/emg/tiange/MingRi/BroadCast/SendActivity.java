package com.emg.tiange.MingRi.BroadCast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.R;

public class SendActivity extends AppCompatActivity {

	private Button mBtnWangzhe;
	private Button mBtnLoL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		mBtnWangzhe = findViewById(R.id.btn_wangzhe);
		mBtnLoL = findViewById(R.id.btn_lol);

		mBtnWangzhe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("wangzhe");
				sendBroadcast(intent);
			}
		});

		mBtnLoL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("LOL");
				sendBroadcast(intent);

			}
		});
	}
}
