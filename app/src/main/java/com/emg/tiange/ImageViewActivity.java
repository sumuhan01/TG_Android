package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

	private ImageView mImg4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view);

		mImg4 = findViewById(R.id.image_4);
		Glide.with(this).load("https://pic.taifua.com/Picture/android/xinyuanjieyi.png").into(mImg4);

	}
}
