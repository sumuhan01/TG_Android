package com.emg.tiange.GridView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emg.tiange.ListView.MyListAdapter;
import com.emg.tiange.R;

public class MyGridAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mLayoutInflater;

	public MyGridAdapter(Context context) {
		this.mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 15;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	static class ViewHolder {
		public ImageView mImageView;
		public TextView mTextV;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.activity_grid_item,null);
			holder = new ViewHolder();
			holder.mImageView = convertView.findViewById(R.id.image_grid);
			holder.mTextV = convertView.findViewById(R.id.iv_title);
			convertView.setTag(holder);
			Log.d("converViewNull:", "重新创建holder跟convertView");
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.mTextV.setText("头像");
		Glide.with(mContext).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=137189038,1499632678&fm=26&gp=0.jpg").into(holder.mImageView);

		return convertView;
	}
}
