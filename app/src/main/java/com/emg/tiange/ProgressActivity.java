package com.emg.tiange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

	ProgressBar mProBar4;
	Button mBtnStart,mBtnProDialog1,mBtnProDialog2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress);

		mProBar4 = findViewById(R.id.pgrb4);
		mBtnStart = findViewById(R.id.btn_start_prog);
		mBtnProDialog1 = findViewById(R.id.btn_prg_dialog1);
		mBtnProDialog2 = findViewById(R.id.btn_prg_dialog2);

		mBtnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				handler.sendEmptyMessage(0);
			}
		});

		mBtnProDialog1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
				progressDialog.setTitle("提示");
				progressDialog.setMessage("正在加载");
				progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
					@Override
					public void onCancel(DialogInterface dialog) {
						Toast.makeText(ProgressActivity.this,"加载完毕",Toast.LENGTH_SHORT).show();
					}
				});
				progressDialog.show();
			}
		});
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(@NonNull Message msg) {
			super.handleMessage(msg);
			if (mProBar4.getProgress() < 100) {
				handler.postDelayed(runnable,500);
			}
			else {
				Toast.makeText(ProgressActivity.this,"加载完毕",Toast.LENGTH_SHORT).show();
			}
		}
	};

	Runnable runnable  = new Runnable() {
		@Override
		public void run() {
			mProBar4.setProgress(mProBar4.getProgress()+5);
			handler.sendEmptyMessage(0);
		}
	};
}
