package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

	private RadioGroup mRadioGr1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button);

		mRadioGr1 = findViewById(R.id.rg_1);
		mRadioGr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				//获取Group中的选中按钮
				RadioButton radioButton = group.findViewById(checkedId);
				Toast.makeText(RadioButtonActivity.this,"按钮值发生了改变，你选择的是"+ radioButton.getText(),Toast.LENGTH_SHORT).show();
			}
		});
	}
}
