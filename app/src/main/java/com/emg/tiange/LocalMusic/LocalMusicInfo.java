package com.emg.tiange.LocalMusic;

public class LocalMusicInfo {
	public String mMusicId;
	public String mMusicSong;
	public String mMusicSinger;
	public String mMusicAlbum;
	public String mMusicDuration;
	public String mMusicPath;
	public String mAlbumArt;

	public LocalMusicInfo(String Id, String Song, String Singer, String Album, String Duration, String Path, String AlbumArt) {
		this.mMusicId = Id;
		this.mMusicSong = Song;
		this.mMusicSinger = Singer;
		this.mMusicAlbum = Album;
		this.mMusicDuration = Duration;
		this.mMusicPath = Path;
		this.mAlbumArt = AlbumArt;
	}

	public String getmMusicId() {
		return mMusicId;
	}

	public void setmMusicId(String mMusicId) {
		this.mMusicId = mMusicId;
	}

	public String getmMusicSong() {
		return mMusicSong;
	}

	public void setmMusicSong(String mMusicSong) {
		this.mMusicSong = mMusicSong;
	}

	public String getmMusicSinger() {
		return mMusicSinger;
	}

	public void setmMusicSinger(String mMusicSinger) {
		this.mMusicSinger = mMusicSinger;
	}

	public String getmMusicAlbum() {
		return mMusicAlbum;
	}

	public void setmMusicAlbum(String mMusicAlbum) {
		this.mMusicAlbum = mMusicAlbum;
	}

	public String getmMusicDuration() {
		return mMusicDuration;
	}

	public void setmMusicDuration(String mMusicDuration) {
		this.mMusicDuration = mMusicDuration;
	}

	public String getmMusicPath() {
		return mMusicPath;
	}

	public void setmMusicPath(String mMusicPath) {
		this.mMusicPath = mMusicPath;
	}

	public String getmAlbumArt() {
		return mAlbumArt;
	}

	public void setmAlbumArt(String mAlbumArt) {
		this.mAlbumArt = mAlbumArt;
	}
}
