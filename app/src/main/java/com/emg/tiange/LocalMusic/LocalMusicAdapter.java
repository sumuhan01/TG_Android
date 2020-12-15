package com.emg.tiange.LocalMusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emg.tiange.R;

import java.util.List;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.LocaMusicViewHolder> {

	private List<LocalMusicInfo> mMusicList;
	private Context context;
	LocaMusicViewHolder musicViewHolder;
	OnItemClickListener itemClickListener;

	public LocalMusicAdapter(List<LocalMusicInfo> mMusicList, Context context) {
		this.mMusicList = mMusicList;
		this.context = context;
	}

	@Override
	public void onBindViewHolder(@NonNull LocaMusicViewHolder holder, final int position) {
		LocalMusicInfo musicInfo = mMusicList.get(position);
		holder.music_id.setText(musicInfo.getmMusicId());
		holder.music_song.setText(musicInfo.getmMusicSong());
		holder.music_singer.setText(musicInfo.getmMusicSinger());
		holder.music_album.setText(musicInfo.getmMusicAlbum());
		holder.music_drution.setText(musicInfo.getmMusicDuration());

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				itemClickListener.OnClick(position);
			}
		});
	}

	@NonNull
	@Override
	public LocaMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		musicViewHolder = new LocaMusicViewHolder(LayoutInflater.from(context).inflate(R.layout.local_music_adapter,parent,false));
		return musicViewHolder;
	}

	@Override
	public int getItemCount() {
		return mMusicList.size();
	}

	class LocaMusicViewHolder extends RecyclerView.ViewHolder{
		TextView music_id,music_song,music_singer,music_album,music_drution;
		public LocaMusicViewHolder(@NonNull View itemView) {
			super(itemView);
			if (itemView != null) {
				music_id = itemView.findViewById(R.id.music_num);
				music_song = itemView.findViewById(R.id.music_song);
				music_singer = itemView.findViewById(R.id.music_singer);
				music_album = itemView.findViewById(R.id.music_album);
				music_drution = itemView.findViewById(R.id.music_durtion);
			}
		}
	}

	public void SetItemClickListener(OnItemClickListener ClickListener) {
		this.itemClickListener = ClickListener;
	}

	public interface OnItemClickListener {
		void OnClick(int pos);
	}
}
