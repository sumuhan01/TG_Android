package com.emg.tiange.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.emg.tiange.R;

public class ListViewActivity extends AppCompatActivity {

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		listView = findViewById(R.id.lv_1);
		//设置适配器
		listView.setAdapter(new MyListAdapter(ListViewActivity.this));

		//设置监听事件
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ListViewActivity.this,"点击" + position, Toast.LENGTH_SHORT).show();
			}
		});

		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ListViewActivity.this,"长按" + position, Toast.LENGTH_SHORT).show();
				return true;
			}
		});



	}
}
