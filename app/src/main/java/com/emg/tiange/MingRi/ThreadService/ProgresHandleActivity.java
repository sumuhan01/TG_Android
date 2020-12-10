package com.emg.tiange.MingRi.ThreadService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.emg.tiange.ProgressActivity;
import com.emg.tiange.R;

public class ProgresHandleActivity extends AppCompatActivity {

	private ProgressBar mProgreass;
	final int mMaxLong = 60;
	private int mCurrPro = 0;
	final int SEND_MSG = 0x01;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progres_handle);

		mProgreass = findViewById(R.id.progres);
		handler.sendEmptyMessage(SEND_MSG);
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(@NonNull Message msg) {
			if (mMaxLong - mCurrPro > 0) {
				mCurrPro++;
				mProgreass.setProgress(mMaxLong - mCurrPro);
				handler.sendEmptyMessageDelayed(SEND_MSG,1000);
			} else {
				Toast.makeText(ProgresHandleActivity.this,"加载完毕",Toast.LENGTH_SHORT).show();
			}
		}
	};
}
