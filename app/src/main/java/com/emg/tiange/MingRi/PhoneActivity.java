package com.emg.tiange.MingRi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.emg.tiange.MingRi.BroadCast.SendActivity;
import com.emg.tiange.MingRi.MediaVedio.MediaActivity;
import com.emg.tiange.MingRi.Service.BoundServiceActivity;
import com.emg.tiange.MingRi.Service.MusicServiceActivity;
import com.emg.tiange.MingRi.Service.MyActivity;
import com.emg.tiange.MingRi.ThreadService.CarouselActivity;
import com.emg.tiange.MingRi.ThreadService.ProgresHandleActivity;
import com.emg.tiange.MingRi.ThreadService.ThreadActivity;
import com.emg.tiange.MingRi.WeChatFragment.WeMainActivity;
import com.emg.tiange.R;

public class PhoneActivity extends AppCompatActivity {

	private ImageButton mBtnPhone;
	private ImageButton mBtnMessage;
	private Button mBtnWeChat;
	private Button mBtnReturnHome;
	private Button mBtnDebug;
	private Button mBtnBroadCast;
	private Button mBtnMedia;
	private Button mBtnThread;
	private Button mBtnProgreHandle;
	private Button mBtnViewFipper;
	private Button mBtnMySer;
	private Button mBtnMusicSer;
	private Button mBtnBoudSer;
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone);

		mBtnPhone = findViewById(R.id.btn_phone);
		mBtnMessage = findViewById(R.id.btn_message);
		mBtnWeChat = findViewById(R.id.btn_wechat);
		mBtnReturnHome = findViewById(R.id.btn_ret_home);
		mBtnDebug = findViewById(R.id.btn_debug);
		mBtnBroadCast = findViewById(R.id.btn_broad);
		mBtnMedia = findViewById(R.id.btn_media);
		mBtnThread = findViewById(R.id.btn_thread);
		mBtnProgreHandle = findViewById(R.id.btn_proghandle);
		mBtnViewFipper = findViewById(R.id.btn_viewfipper);
		mBtnMySer = findViewById(R.id.btn_servic);
		mBtnMusicSer = findViewById(R.id.btn_music_service);
		mBtnBoudSer = findViewById(R.id.btn_bound_service);

		mBtnPhone.setOnClickListener(listener);
		mBtnMessage.setOnClickListener(listener);
		mBtnWeChat.setOnClickListener(listener);
		mBtnReturnHome.setOnClickListener(listener);
		mBtnDebug.setOnClickListener(listener);
		mBtnBroadCast.setOnClickListener(listener);
		mBtnMedia.setOnClickListener(listener);
		mBtnThread.setOnClickListener(listener);
		mBtnProgreHandle.setOnClickListener(listener);
		mBtnViewFipper.setOnClickListener(listener);
		mBtnMySer.setOnClickListener(listener);
		mBtnMusicSer.setOnClickListener(listener);
		mBtnBoudSer.setOnClickListener(listener);

	}

	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//隐士Intent
			Intent intent = new Intent();
			switch (v.getId()) {
				case R.id.btn_phone:
					intent.setAction(Intent.ACTION_DIAL);
					intent.setData(Uri.parse("tel:10010"));
					startActivity(intent);
					break;

				case R.id.btn_message:
					intent.setAction(Intent.ACTION_SENDTO);
					intent.setData(Uri.parse("smsto:dididada"));
					intent.putExtra("hello","helloworld!");
					startActivity(intent);
					break;

				case R.id.btn_wechat:
					intent = new Intent(PhoneActivity.this, WeMainActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_ret_home:
					intent.setAction(Intent.ACTION_MAIN);
					intent.addCategory(Intent.CATEGORY_HOME);
					startActivity(intent);
					break;
				case R.id.btn_debug:
					intent = new Intent(PhoneActivity.this, DebugActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_broad:
					intent = new Intent(PhoneActivity.this, SendActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_media:
					intent = new Intent(PhoneActivity.this, MediaActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_thread:
					intent = new Intent(PhoneActivity.this, ThreadActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_proghandle:
					intent = new Intent(PhoneActivity.this, ProgresHandleActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_viewfipper:
					intent = new Intent(PhoneActivity.this, CarouselActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_servic:
					intent = new Intent(PhoneActivity.this, MyActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_music_service:
					intent = new Intent(PhoneActivity.this, MusicServiceActivity.class);
					startActivity(intent);
					break;

				case R.id.btn_bound_service:
					intent = new Intent(PhoneActivity.this, BoundServiceActivity.class);
					startActivity(intent);
					break;

				default:break;
			}
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == event.KEYCODE_BACK) {
			exit();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void exit() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			Toast.makeText(getApplicationContext(),"再按一次返回键退出",Toast.LENGTH_SHORT).show();  //getApp
			exitTime = System.currentTimeMillis();
		} else {
			finish();
			System.exit(0);
		}
	}
}
