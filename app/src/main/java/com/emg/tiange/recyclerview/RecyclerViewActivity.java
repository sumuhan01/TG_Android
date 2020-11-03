package com.emg.tiange.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emg.tiange.R;

public class RecyclerViewActivity extends AppCompatActivity {

	private Button mBtnLiear;
	private Button mBtnHoriz;
	private Button mBtnGrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycle_view);

		mBtnLiear = findViewById(R.id.btn_linear);
		mBtnHoriz = findViewById(R.id.btn_horiz);
		mBtnGrid = findViewById(R.id.btn_grid);

		mBtnLiear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
				startActivity(intent);
			}
		});

		mBtnHoriz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RecyclerViewActivity.this,HoriRecyclerViewActivity.class);
				startActivity(intent);
			}
		});

		mBtnGrid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
				startActivity(intent);
			}
		});

	}
}
