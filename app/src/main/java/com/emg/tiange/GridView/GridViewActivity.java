package com.emg.tiange.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.emg.tiange.R;

public class GridViewActivity extends AppCompatActivity {

	private GridView mGridV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);

		mGridV = findViewById(R.id.gv_1);

		mGridV.setAdapter(new MyGridAdapter(GridViewActivity.this));

		mGridV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridViewActivity.this,"点击了图片第" + position, Toast.LENGTH_SHORT).show();
			}
		});

		mGridV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridViewActivity.this,"长按了图片第" + position, Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
}
