package com.emg.tiange.MingRi.MediaVedio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.emg.tiange.R;

import java.io.File;
import java.io.IOException;

public class MediaActivity extends AppCompatActivity {

	private MediaPlayer mediaPlayer;
	private ImageButton mBtnPlay;
	private ImageButton mBtnStop;
	private boolean isPause = false;
	private File file;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media);

		mBtnPlay = findViewById(R.id.btn_play);
		mBtnStop = findViewById(R.id.btn_stop);
		file = new File("/sdcard/qqmusic/song/张雨生 - 我的未来不是梦 [mqms2].mp3");

		if (file.exists()) {
			mediaPlayer = MediaPlayer.create(this, Uri.parse(file.getAbsolutePath()));
		} else {
			Toast.makeText(MediaActivity.this,"音频文件不存在",Toast.LENGTH_SHORT).show();
		}

		mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				//当音乐播放完成后重新播放
				rePlay();
			}
		});

		mBtnPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying() && !isPause) {
					mediaPlayer.pause();
					isPause = true;
					((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.pause));
				} else {
					mediaPlayer.start();
					isPause = false;
					((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play));
				}
			}
		});

		mBtnStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mediaPlayer.stop();
				mBtnPlay.setImageDrawable(getResources().getDrawable(R.drawable.play));
			}
		});
	}

	private void rePlay() {
		mediaPlayer.reset(); //重置Media对象
		try {
			mediaPlayer.setDataSource(file.getAbsolutePath());
			mediaPlayer.prepare(); //预加载
			mediaPlayer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onDestroy() {
		if(mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
		}
		mediaPlayer.release(); //释放资源
		super.onDestroy();
	}
}
