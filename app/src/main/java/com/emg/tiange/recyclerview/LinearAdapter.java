package com.emg.tiange.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emg.tiange.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private Context mContext;
	private OnItemClickListener mListener;

	public LinearAdapter(Context context, OnItemClickListener listener) {
		this.mContext = context;
		this.mListener = listener;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
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
		return 30;
	}

	class LinearViewHolder extends RecyclerView.ViewHolder {
		private TextView textView;
		public LinearViewHolder(@NonNull View itemView) {
			super(itemView);
			textView = itemView.findViewById(R.id.tv_title);
		}
	}

	public interface OnItemClickListener {
		void onClick(int pos);
	}
}
