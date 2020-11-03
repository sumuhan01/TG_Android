package com.emg.tiange.ListView;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emg.tiange.R;

public class MyListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mLayoutInflater;

	public MyListAdapter(Context context) {
		this.mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}

	static class ViewHolder {
		public ImageView mImgaeView;
		public TextView tvTitle,tvTiem,tvConten;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.activity_list_item, null);
			holder = new ViewHolder();
			holder.mImgaeView = convertView.findViewById(R.id.image_1);
			holder.tvTitle = convertView.findViewById(R.id.tv_title);
			holder.tvTiem = convertView.findViewById(R.id.tv_time);
			holder.tvConten = convertView.findViewById(R.id.tv_content);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tvTitle.setText("安卓应用开发");
		holder.tvTiem.setText("2020-10-14");
		holder.tvConten.setText("hello android");
		Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603802510871&di=0ab61a82473466928582d1e4ed274ed5&imgtype=0&src=http%3A%2F%2Fpic29.nipic.com%2F20130522%2F12421584_133951593000_2.jpg").into(holder.mImgaeView);

		return convertView;
	}
}
