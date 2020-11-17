package com.emg.tiange.TestView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.R;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {

	private Button mBtnTextClock;
	private Button mBtnChronometerClock;
	private Button mBtnDalogClock;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_time);
		mBtnTextClock = findViewById(R.id.btn_text_clock);
		mBtnChronometerClock = findViewById(R.id.btn_chronnometer_clock);
		mBtnDalogClock = findViewById(R.id.btn_dalog_clock);
		mBtnTextClock.setOnClickListener(this);
		mBtnDalogClock.setOnClickListener(this);
		mBtnChronometerClock.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
			case R.id.btn_text_clock:
				intent = new Intent(DateTimeActivity.this,TextClockActivtity.class);
				break;
			case R.id.btn_chronnometer_clock:
				intent = new Intent(DateTimeActivity.this,ChronometerActivity.class);
				break;
			case R.id.btn_dalog_clock:
				intent = new Intent(DateTimeActivity.this,DalogClockActivity.class);
				break;

				default:break;
		}
		startActivity(intent);
	}
}
