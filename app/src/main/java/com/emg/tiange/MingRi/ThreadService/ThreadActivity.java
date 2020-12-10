package com.emg.tiange.MingRi.ThreadService;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.emg.tiange.R;

public class ThreadActivity extends AppCompatActivity {

	private final String TAG = "ThreadActivity";
	private Button mBtnThStart;
	private Button mBtnThStop;
	private Button mBtnChang;
	private TextView mTxDisplay;
	private int mCount = 0;
	Thread thread = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);

		mBtnThStart = findViewById(R.id.btn_thstart);
		mBtnThStop = findViewById(R.id.btn_thstop);
		mBtnChang = findViewById(R.id.btn_display_change);
		mTxDisplay = findViewById(R.id.tx_display);

		mBtnThStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCount = 0;
				//thread = new Thread(ThreadActivity.this);
				thread.start();
			}
		});

		mBtnThStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (thread != null)
				thread.interrupt();
				thread =null;
			}
		});

		mBtnChang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//创建线程
				Thread thread1 = new Thread(new Runnable(){
					@Override
					public void run() {
						//视图通过子线程修改主线程UI显示
						mTxDisplay.setText("跨过山河大海，依旧保持初心");

						//运行居然可以修改，不知是不是含有多个模块的原因
					}
				});
				thread1.start();
			}
		});
	}

//	@Override
//	public void run() {
//		while (!Thread.currentThread().isInterrupted() && thread != null) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			mCount++;
//			Log.i(TAG + "循环次数",String.valueOf(mCount));
//		}
//	}

	@Override
	protected void onDestroy() {
		if (thread != null) {
			thread.interrupt();
			thread = null;
		}
		super.onDestroy();
	}
}
