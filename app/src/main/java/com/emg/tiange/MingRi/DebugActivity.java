package com.emg.tiange.MingRi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.emg.tiange.R;

import java.util.Random;

public class DebugActivity extends AppCompatActivity {
	private static String TAG = "DebugActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug);
		Log.e(TAG,"[错误信息]");
		Log.w(TAG,"[警告信息]");
		Log.d(TAG,"[调式信息]");
		Log.i(TAG,"[info信息]");
		Log.v(TAG,"[冗余信息]");
		int a = random(2,9);
		int b = random(0,20);

	}

	private int random(int start,int end)
	{
		Random random = new Random();
		int ret = random.nextInt(end) + start;
		return ret;
	}
}
