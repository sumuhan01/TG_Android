package com.emg.tiange.MingRi.WeChatFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.emg.tiange.R;

public class WeMainActivity extends AppCompatActivity implements View.OnClickListener {

	ImageView mImgWeChat;
	ImageView mImgFind;
	ImageView mImgMe;
	ImageView mImgMsg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_we_main);

		mImgWeChat = findViewById(R.id.image_wechat);
		mImgFind = findViewById(R.id.image_find);
		mImgMe = findViewById(R.id.image_me);
		mImgMsg = findViewById(R.id.image_tongxun);

		mImgWeChat.setOnClickListener(this);
		mImgFind.setOnClickListener(this);
		mImgMe.setOnClickListener(this);
		mImgMsg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		FragmentManager fm = getSupportFragmentManager(); //获取FM管理器
		FragmentTransaction ft = fm.beginTransaction();
		Fragment fragment = null;
		switch (v.getId())
		{
			case R.id.image_wechat:
				fragment = new WeChat_Fragment();
				break;

			case R.id.image_find:
				fragment = new Find_Fragment();
				break;

			case R.id.image_me:
				fragment = new me_Fragment();
				break;

			case R.id.image_tongxun:
				fragment = new message_Fragment();
				break;

				default:break;
		}
		if (fragment != null) {
			ft.replace(R.id.fragment,fragment);
			ft.commit();
		}
	}
}
