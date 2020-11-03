package com.emg.tiange.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emg.tiange.R;

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private Context mContext;
	OnItemClickListener mListener;

	public GridAdapter(Context context, OnItemClickListener listener) {
		this.mContext = context;
		this.mListener = listener;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recycler_item,parent,false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onClick(position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return 20;
	}

	class MyViewHolder extends RecyclerView.ViewHolder {
		private TextView textView;
		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			textView = itemView.findViewById(R.id.tv_title);
		}
	}

	public interface OnItemClickListener {
		void onClick(int pos);
	}
}
