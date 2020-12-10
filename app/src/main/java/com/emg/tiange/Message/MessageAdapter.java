package com.emg.tiange.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emg.tiange.R;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private Context mContext;
	private LayoutInflater layoutInflater;
	private List<MessageInfo> messageInfoList;
	OnItemClickListener mListener;
	MessageViewHolder messageViewHolder = null;

	public MessageAdapter(Context context,List<MessageInfo> list,OnItemClickListener listener) {
		this.mContext = context;
		this.messageInfoList = list;
		this.mListener = listener;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public long getItemId(int position) {
		return super.getItemId(position);
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		messageViewHolder = new MessageViewHolder(layoutInflater.inflate(R.layout.message_layout,parent,false));
		return messageViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
		if(messageViewHolder != null) {
			if (messageInfoList.get(position).getMsgType() == 1) {
				messageViewHolder.mMsgType.setText("接收");
			} else {
				messageViewHolder.mMsgType.setText("发送");
			}
			messageViewHolder.mMsgDate.setText(messageInfoList.get(position).getMsgDate());
			messageViewHolder.mMsgBody.setText(messageInfoList.get(position).getMsgPhone());
		}

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.OnClick(position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return messageInfoList.size();
	}

	class MessageViewHolder extends RecyclerView.ViewHolder {

		public TextView mMsgBody;
		public TextView mMsgDate;
		public TextView mMsgType;
		public MessageViewHolder(@NonNull View itemView) {
			super(itemView);
			mMsgBody = itemView.findViewById(R.id.msg_body);
			mMsgDate = itemView.findViewById(R.id.msg_date);
			mMsgType = itemView.findViewById(R.id.msg_type);
		}
	}

	public interface OnItemClickListener {
		void OnClick(int position);
	}
}
