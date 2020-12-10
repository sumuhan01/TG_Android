package com.emg.tiange.MingRi.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.R;

public class MyActivity extends AppCompatActivity {

	private Button mBtnStart;
	private Button mBtnStop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

		mBtnStart = findViewById(R.id.btn_ser_start);
		mBtnStop = findViewById(R.id.btn_ser_stop);
		final Intent intent = new Intent(MyActivity.this,MyService.class);

		mBtnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(intent);
			}
		});

		mBtnStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService(intent);
			}
		});
	}
}
