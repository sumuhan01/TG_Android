package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.BroadcastReceiver.BroadcastActivity1;
import com.emg.tiange.GridView.GridViewActivity;
import com.emg.tiange.HanlerView.HanlerViewActivity1;
import com.emg.tiange.ListView.ListViewActivity;
import com.emg.tiange.MingRi.PhoneActivity;
import com.emg.tiange.NetworkCom.NetworkActivity;
import com.emg.tiange.TestView.DateTimeActivity;
import com.emg.tiange.fragment.ContainerActivity;
import com.emg.tiange.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {


	private Button mBtnTestView;
	private Button mBtnTianGeView;
	private Button mBtnMingRiView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mBtnTestView = findViewById(R.id.btn_test_view);
		mBtnTianGeView = findViewById(R.id.btn_tiange_view);
		mBtnMingRiView = findViewById(R.id.btn_mingri_view);
		setListeners();
	}

	private void setListeners() {
		OnClick onClick = new OnClick();
		mBtnTestView.setOnClickListener(onClick);
		mBtnTianGeView.setOnClickListener(onClick);
		mBtnMingRiView.setOnClickListener(onClick);
	}

	//实现接听器接口
	private class OnClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
				case R.id.btn_tiange_view:
					intent = new Intent(MainActivity.this, UIDisplayActivity.class);
					break;

				case R.id.btn_test_view:
					intent = new Intent(MainActivity.this, DateTimeActivity.class);
					break;

				case R.id.btn_mingri_view:
					intent = new Intent(MainActivity.this, PhoneActivity.class);
					break;

					default:
						break;
			}
			startActivity(intent);
		}
	}
}
