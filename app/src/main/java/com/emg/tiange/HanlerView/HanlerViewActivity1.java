package com.emg.tiange.HanlerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.emg.tiange.ButtonActivity;
import com.emg.tiange.R;

public class HanlerViewActivity1 extends AppCompatActivity {

	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hanler_view1);
//		handler = new Handler();
//		handler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				Intent intent = new Intent(HanlerViewActivity1.this, ButtonActivity.class);
//				startActivity(intent);
//			}
//		}, 3000);

		handler = new Handler() {
			@Override
			public void handleMessage(@NonNull Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
					case 1024:
						Toast.makeText(HanlerViewActivity1.this,"子线程中启动Handler处理",Toast.LENGTH_SHORT).show();
						break;
				}
			}
		};

		Thread thread = new Thread() {
			@Override
			public void run() {
				super.run();
				Message message = new Message();
				message.what = 1024;
				handler.sendMessage(message);
			}
		};
		thread.start();
    }
}
