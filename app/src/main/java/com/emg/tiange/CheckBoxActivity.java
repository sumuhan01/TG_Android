package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

	private CheckBox mCbx1;
	private CheckBox mCbx2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box);

		mCbx1 = findViewById(R.id.checkbox_3);
		mCbx2 = findViewById(R.id.checkbox_2);

		mCbx1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//增加mCbx1选中事件
				Toast.makeText(CheckBoxActivity.this,isChecked?"checkbox1选中":"checkbox1未选中",Toast.LENGTH_SHORT).show();
			}
		});

		mCbx2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(CheckBoxActivity.this,isChecked?"checkbox2选中":"checkbox2未选中",Toast.LENGTH_SHORT).show();
			}
		});
	}
}
