package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

	private Button mBtn3;
	private TextView mText1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);

		mBtn3 = findViewById(R.id.btn_3);
		mBtn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ButtonActivity.this,"Btn3被点击了",Toast.LENGTH_SHORT).show();
			}
		});

		mText1 = findViewById(R.id.tv_1);
		mText1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ButtonActivity.this,"textview1被点击了", Toast.LENGTH_SHORT).show();
			}
		});
	}

	//该函数在activity_button.xml 按钮4中隐式调用
	public void showToast(View v) {
		Toast.makeText(ButtonActivity.this,"Btn4被点击了",Toast.LENGTH_SHORT).show();
	}
}
