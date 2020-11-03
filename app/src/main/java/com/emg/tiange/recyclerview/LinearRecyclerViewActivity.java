package com.emg.tiange.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emg.tiange.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

	private RecyclerView mRecvMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linear_recycler_view);

		mRecvMain = findViewById(R.id.rv_main);

		//设置水平布局管理器
		mRecvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));

		//下划线
		mRecvMain.addItemDecoration(new MyDecoration());
		//设置适配器
		mRecvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {

			//添加自定义监听事件，Recycle没有监听事件
			@Override
			public void onClick(int pos) {
				Toast.makeText(LinearRecyclerViewActivity.this,"Click..." + pos, Toast.LENGTH_SHORT).show();
			}
		}));
	}
	//添加分割线
	class MyDecoration extends RecyclerView.ItemDecoration {
		@Override
		public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
			super.getItemOffsets(outRect, view, parent, state);
			outRect.set(0,0,0,5);
		}
	}
}
