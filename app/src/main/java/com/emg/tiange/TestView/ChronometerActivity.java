package com.emg.tiange.TestView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.emg.tiange.R;

public class ChronometerActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener {

	private Button mBtnStartTime;
	private Button mBtnStopTime;
	private Button mBtnRestTime;
	private Button mBtnFormat;
	private Chronometer chronometer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chronometer);
		mBtnStartTime = findViewById(R.id.btn_start);
		mBtnStopTime = findViewById(R.id.btn_stop);
		mBtnRestTime = findViewById(R.id.btn_rest);
		mBtnFormat = findViewById(R.id.btn_fromat);
		chronometer = findViewById(R.id.chronometer);
		chronometer.setOnChronometerTickListener(this);
		onListener();


	}

	public void onListener()
	{
		onClick mOnClick = new onClick();
		mBtnStartTime.setOnClickListener(mOnClick);
		mBtnStopTime.setOnClickListener(mOnClick);
		mBtnRestTime.setOnClickListener(mOnClick);
		mBtnFormat.setOnClickListener(mOnClick);

	}
	public class onClick implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId())
			{
				case R.id.btn_start:
					chronometer.start();
					Log.d("chronometer.start()","+++++");
					break;
				case R.id.btn_stop:
					chronometer.stop();
					break;
				case R.id.btn_rest:
					chronometer.setBase(SystemClock.elapsedRealtime());
					break;
				case R.id.btn_fromat:
					chronometer.setFormat("Time:%s");
					break;

					default:break;
			}
		}
	}

	@Override
	public void onChronometerTick(Chronometer chronometer) {
		String time = chronometer.getText().toString();
		if(time.equals("00:00")){
			Toast.makeText(ChronometerActivity.this,"时间到了~",Toast.LENGTH_SHORT).show();
		}
	}
}
