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

public class HoriRecyclerViewActivity extends AppCompatActivity {

	private RecyclerView mRecvMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hori_recycler_view);

		mRecvMain = findViewById(R.id.rv_horz);

		//设定水平互动布局管理
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HoriRecyclerViewActivity.this);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		mRecvMain.setLayoutManager(linearLayoutManager);

		mRecvMain.addItemDecoration(new MyDecoration());

		//设置适配器
		mRecvMain.setAdapter(new HorizAdapter(HoriRecyclerViewActivity.this, new HorizAdapter.OnItemClickListener() {
			@Override
			public void onClick(int pos) {
				Toast.makeText(HoriRecyclerViewActivity.this,"Click..."+pos,Toast.LENGTH_SHORT).show();
			}
		}));
	}

	//设置分割线
	class MyDecoration extends RecyclerView.ItemDecoration {
		@Override
		public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
			super.getItemOffsets(outRect, view, parent, state);
			outRect.set(0,0,5,0);
		}
	}
}


