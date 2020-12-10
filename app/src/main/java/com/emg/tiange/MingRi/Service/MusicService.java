package com.emg.tiange.MingRi.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.emg.tiange.R;

public class MusicService extends Service {

	static boolean isPause;  //设置类变量，外部通过类名访问
	private MediaPlayer mediaPlayer;

	public MusicService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		Log.i("MusicService","Service start");
		mediaPlayer = MediaPlayer.create(this, R.raw.music);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MusicService","Service Running");
		if(mediaPlayer.isPlaying() == false) {
			mediaPlayer.start();
			isPause = mediaPlayer.isPlaying();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i("MusicService","Service stop");
		mediaPlayer.stop();
		isPause = mediaPlayer.isPlaying();
		mediaPlayer.release();
		super.onDestroy();
	}
}
