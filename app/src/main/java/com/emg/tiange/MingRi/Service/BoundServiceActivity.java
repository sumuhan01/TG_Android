package com.emg.tiange.MingRi.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emg.tiange.R;

import java.util.List;

public class BoundServiceActivity extends AppCompatActivity {

	BoundService boundService;
	private Button mBtnChang;
	int[] textV = new int[] {R.id.textview1,R.id.textview2,R.id.textview3,
			R.id.textview4,R.id.textview5,R.id.textview6,R.id.textview7};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bound_service);
		mBtnChang = findViewById(R.id.chang_random);

		mBtnChang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List number = boundService.getRandomNumber();  //获取后台servic的随机数列表
				for (int i = 0; i < number.size(); i++) {
					String strNumnber = number.get(i).toString();
					TextView textView = findViewById(textV[i]);
					textView.setText(strNumnber);
				}
			}
		});
	}

	//实现监控连接器
	private ServiceConnection connection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//获取后台service信息
			boundService = ((BoundService.MyBinder) service).getService(); //后去后台service对象

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}
	};

	@Override
	protected void onStart() {  //设置Activity启动时就与后台service建立连接
		super.onStart();
		Intent intent = new Intent(BoundServiceActivity.this,BoundService.class);
		bindService(intent,connection,BIND_AUTO_CREATE);  //绑定后台service
	}

	@Override
	protected void onStop() {
		super.onStop();
		unbindService(connection); //解除Activity与后台service的绑定
	}
}
