package com.emg.tiange.HLink.Phone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.emg.tiange.R;

import java.util.List;
import java.util.zip.Inflater;

public class PhoneAdapter extends BaseAdapter {

	private List<Presonal> mPhoneList;
	private Context context;

	public PhoneAdapter(List<Presonal> list, Context context) {
		this.mPhoneList = list;
		this.context = context;
	}
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getCount() {
		return mPhoneList.size();
	}

	@Override
	public Object getItem(int position) {
		return mPhoneList.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(this.context).inflate(R.layout.phone_adapter_layout,null);
			viewHolder = new ViewHolder();
			viewHolder.mName = convertView.findViewById(R.id.tx_name);
			viewHolder.mNum = convertView.findViewById(R.id.tx_num);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mName.setText(mPhoneList.get(position).getmPresonName());
		viewHolder.mNum.setText(mPhoneList.get(position).getmPresonNum());
		return convertView;
	}

	private static class ViewHolder {
		TextView mName;
		TextView mNum;
	}
}

