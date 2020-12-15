package com.emg.tiange.LocalMusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emg.tiange.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocalMusicActivity extends AppCompatActivity implements View.OnClickListener{

	private String TAG = "LocalMusicActivity";
	private TextView mTextSong;
	private TextView mTextSinger;
	private ImageView mLastMusic;
	private ImageView mPlayMusic;
	private ImageView mNextMusic;

	private List<LocalMusicInfo> musicInfoList;
	private LocalMusicAdapter musicAdapter;
	private MediaPlayer mediaPlayer;
	private RecyclerView mMusciRecy;
	//记录当前正在播放的音乐的位置
	int currnetPlayPosition = -1;
	//记录暂停音乐时进度条的位置
	int currentPausePositionInSong = 0;

	//针对sd卡读取权限申请
	private static final int REQUEST_EXTERNAL_STORAGE = 1;
	private static String[] PERMISSIONS_STORAGE = {
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.WRITE_EXTERNAL_STORAGE
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_music);
		initView();
		mediaPlayer = new MediaPlayer();
		musicInfoList = new ArrayList<>();
		musicAdapter = new LocalMusicAdapter(musicInfoList,this);
		mMusciRecy.setAdapter(musicAdapter);
		mMusciRecy.setLayoutManager(new LinearLayoutManager(LocalMusicActivity.this));
		verifyStoragePermissions(this);
		//加载本地音乐数据
		LoadLocalMusicData();

		//监听事件
		SetEventListener();
	}

	private void initView() {
		mTextSong = findViewById(R.id.botton_music_song);
		mTextSinger = findViewById(R.id.bottom_musi_singer);
		mLastMusic = findViewById(R.id.bottom_music_last);
		mPlayMusic = findViewById(R.id.bottom_music_play);
		mNextMusic = findViewById(R.id.bottom_music_next);
		mMusciRecy = findViewById(R.id.local_music_recycler);

		mLastMusic.setOnClickListener(this);
		mPlayMusic.setOnClickListener(this);
		mNextMusic.setOnClickListener(this);
	}

	//读写去权限申请
	public static void verifyStoragePermissions(Activity activity) {
		// Check if we have write permission
		int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
		if (permission != PackageManager.PERMISSION_GRANTED) {
			// We don't have permission so prompt the user
			ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
		}
	}

	private void LoadLocalMusicData() {
		//获取数据库数据
		ContentResolver contentResolver = getContentResolver();
		//本地音乐URI地址
		Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		Cursor cursor = contentResolver.query(uri,null,null,null,null);

		int id = 0;
		while (cursor.moveToNext()) {
			String song = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
			String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
			String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
			id++;
			String music_id = String.valueOf(id);
			String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
			Long drution = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
			String time = simpleDateFormat.format(new Date(drution));
			String album_id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
			String albumArt = getAlbumArt(album_id);
			LocalMusicInfo musicInfo;
			musicInfo = new LocalMusicInfo(music_id,song,singer,album,time,path,albumArt);
			musicInfoList.add(musicInfo);
		}
		cursor.close();
		musicAdapter.notifyDataSetChanged();
	}

	private String getAlbumArt(String album_id) {
		String mUriAlbums = "content://media/external/audio/albums";
		String[] projection = new String[]{"album_art"};
		Cursor cur = this.getContentResolver().query(
				Uri.parse(mUriAlbums + "/" + album_id),
				projection, null, null, null);
		String album_art = null;
		if (cur.getCount() > 0 && cur.getColumnCount() > 0) {
			cur.moveToNext();
			album_art = cur.getString(0);
		}
		cur.close();
		cur = null;
		return album_art;
	}

	private void SetEventListener() {
		musicAdapter.SetItemClickListener(new LocalMusicAdapter.OnItemClickListener() {
			@Override
			public void OnClick(int pos) {
				LocalMusicInfo musicInfo = musicInfoList.get(pos);
				currnetPlayPosition = pos;
				DisplayPlayMusicInfo(musicInfo);
			}
		});
	}

	private void DisplayPlayMusicInfo(LocalMusicInfo musicInfo) {
		mTextSong.setText(musicInfo.getmMusicSong());
		mTextSinger.setText(musicInfo.getmMusicSong());
		StopMusic();
		mediaPlayer.reset();

		try {
			mediaPlayer.setDataSource(musicInfo.getmMusicPath());
			PlayMusic();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void PlayMusic() {
		if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
			if (currentPausePositionInSong == 0) {
				//当前音乐进度为0，先预加载在启动播放
				try {
					mediaPlayer.prepare();
					mediaPlayer.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				mediaPlayer.seekTo(currentPausePositionInSong);
				mediaPlayer.start();
			}
			mPlayMusic.setImageResource(R.drawable.icon_pause);
		}
	}

	private void PauseMusic() {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			currentPausePositionInSong = mediaPlayer.getCurrentPosition();
			mediaPlayer.pause();
			mPlayMusic.setImageResource(R.drawable.icon_play);
		}
	}

	private void StopMusic() {
		if (mediaPlayer != null) {
			currentPausePositionInSong = 0;
			mediaPlayer.seekTo(0);
			mediaPlayer.pause();
			mediaPlayer.stop();
			mPlayMusic.setImageResource(R.drawable.icon_play);
		}
	}

	@Override
	protected void onDestroy() {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bottom_music_last:
				if (musicInfoList != null) {
					if (currnetPlayPosition == 0) {
						//当前播放到第一首了，需要播放最后一首
						currnetPlayPosition = musicInfoList.size()-1;
					}
					else currnetPlayPosition = currnetPlayPosition -1;
					LocalMusicInfo musicInfo =  musicInfoList.get(currnetPlayPosition);
					DisplayPlayMusicInfo(musicInfo);
				}
				break;

			case R.id.bottom_music_play:
				if (currnetPlayPosition == -1) {
					//当前没有选择音乐
					Toast.makeText(LocalMusicActivity.this,"请选择需要播放的音乐",Toast.LENGTH_SHORT).show();
					return;
				}
				if (mediaPlayer.isPlaying()) {
					PauseMusic(); //暂停
				} else {
					PlayMusic(); //播放
				}
				break;

			case R.id.bottom_music_next:
				if (musicInfoList != null) {
					if (currnetPlayPosition == (musicInfoList.size()- 1)) {
						//播放到最后一曲，回到第一首
						currnetPlayPosition = 0;
					} else currnetPlayPosition = currnetPlayPosition + 1;
					LocalMusicInfo musicInfo =  musicInfoList.get(currnetPlayPosition);
					DisplayPlayMusicInfo(musicInfo);
				}
				break;
			default:
				break;
		}
	}
}
