package com.emg.tiange.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emg.tiange.R;

import java.util.function.ToDoubleBiFunction;

public class GridRecyclerViewActivity extends AppCompatActivity {

	private RecyclerView mRecvMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_recycler_view);

		mRecvMain = findViewById(R.id.rv_grid);

		mRecvMain.addItemDecoration(new MyDecoration());
		mRecvMain.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));

		mRecvMain.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
			@Override
			public void onClick(int pos) {
				Toast.makeText(GridRecyclerViewActivity.this,"Click..."+pos,Toast.LENGTH_SHORT).show();
			}
		}));
	}

	class MyDecoration extends RecyclerView.ItemDecoration {
		@Override
		public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
			super.getItemOffsets(outRect, view, parent, state);
			//outRect.set();
		}
	}
}
