package com.emg.tiange.MingRi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.emg.tiange.MingRi.BroadCast.SendActivity;
import com.emg.tiange.MingRi.WeChatFragment.WeMainActivity;
import com.emg.tiange.R;

public class PhoneActivity extends AppCompatActivity {

	private ImageButton mBtnPhone;
	private ImageButton mBtnMessage;
	private Button mBtnWeChat;
	private Button mBtnReturnHome;
	private Button mBtnDebug;
	private Button mBtnBroadCast;

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

		mBtnPhone.setOnClickListener(listener);
		mBtnMessage.setOnClickListener(listener);
		mBtnWeChat.setOnClickListener(listener);
		mBtnReturnHome.setOnClickListener(listener);
		mBtnDebug.setOnClickListener(listener);
		mBtnBroadCast.setOnClickListener(listener);
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
					Intent intent1 = new Intent(PhoneActivity.this, WeMainActivity.class);
					startActivity(intent1);
					break;

				case R.id.btn_ret_home:
					intent.setAction(Intent.ACTION_MAIN);
					intent.addCategory(Intent.CATEGORY_HOME);
					startActivity(intent);
					break;
				case R.id.btn_debug:
					Intent intent2 = new Intent(PhoneActivity.this, DebugActivity.class);
					startActivity(intent2);
					break;

				case R.id.btn_broad:
					Intent intent3 = new Intent(PhoneActivity.this, SendActivity.class);
					startActivity(intent3);
					break;
					default:break;
			}
		}
	};
}
