package com.emg.tiange.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.emg.tiange.R;

import java.util.List;

public class MessageActivity extends AppCompatActivity {
	private RecyclerView mMsgRecycler;
	private List<MessageInfo> mMsgListInfo;
	private MessageAdapter mMsgAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		initView();
	}

	private void initView() {
		mMsgRecycler = findViewById(R.id.msg_recycle);
		mMsgRecycler.setLayoutManager(new LinearLayoutManager(MessageActivity.this));
		GetMessageInfo getMessageInfo = new GetMessageInfo();
		mMsgListInfo = getMessageInfo.GetMessage(this);
		mMsgAdapter = new MessageAdapter(this, mMsgListInfo, new MessageAdapter.OnItemClickListener() {
			@Override
			public void OnClick(int position) {
				Intent intent = new Intent(MessageActivity.this,MessagDisplayActivity.class);
				String msgBody = mMsgListInfo.get(position).getMsgBody();
				Bundle bundle = new Bundle();
				bundle.putString("msg_body",msgBody);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		//设置分割线
		mMsgRecycler.addItemDecoration(new MyDecoration());
		mMsgRecycler.setAdapter(mMsgAdapter);
	}

	class MyDecoration extends RecyclerView.ItemDecoration {
		@Override
		public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
			super.getItemOffsets(outRect, view, parent, state);
			outRect.set(0,0,0,5);
		}
	}
}
