package com.emg.tiange.TestView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.emg.tiange.R;

import java.util.Calendar;

public class DalogClockActivity extends AppCompatActivity implements View.OnClickListener {

	private Button mBtnDateSet, mBtnTimeSet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dalog_clock);
		mBtnDateSet = findViewById(R.id.btn_set_date);
		mBtnTimeSet = findViewById(R.id.btn_set_time);
		mBtnDateSet.setOnClickListener(this);
		mBtnTimeSet.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btn_set_date:
				Calendar calendar = Calendar.getInstance();
				new DatePickerDialog(DalogClockActivity.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
						Toast.makeText(DalogClockActivity.this,"您选择的是"+year
						+"年" + month + "月" + dayOfMonth +  "日",Toast.LENGTH_SHORT).show();
					}
				}
				,calendar.get(Calendar.YEAR)
				,calendar.get(Calendar.MONTH)
				,calendar.get(Calendar.DATE)).show();
				break;

			case R.id.btn_set_time:
				Calendar calendar1 = Calendar.getInstance();
				new TimePickerDialog(DalogClockActivity.this, new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						Toast.makeText(DalogClockActivity.this,"你选择的是"
						+ hourOfDay + "时" + minute + "分",Toast.LENGTH_SHORT).show();
					}
				}
				, calendar1.get(Calendar.HOUR_OF_DAY)
				,calendar1.get(Calendar.MINUTE)
				,true).show();
				break;
		}
	}
}
