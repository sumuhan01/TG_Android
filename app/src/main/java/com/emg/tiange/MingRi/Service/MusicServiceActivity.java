package com.emg.tiange.MingRi.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.emg.tiange.R;

public class MusicServiceActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_service);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

		ImageButton mPlay = findViewById(R.id.btn_music_sts);
		final Intent intent = new Intent(MusicServiceActivity.this,MusicService.class);  //为什么不能用private
		mPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (MusicService.isPause == false) {
					startService(intent);
					((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.music_play));
				} else {
					stopService(intent);
					((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.music_stop));
				}
			}
		});
	}

	@Override
	protected void onStart() {
		Intent intent = new Intent(MusicServiceActivity.this,MusicService.class);
		startService(intent);
		super.onStart();
	}
}
