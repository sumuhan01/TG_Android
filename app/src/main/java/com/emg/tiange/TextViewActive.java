package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActive extends AppCompatActivity {

	private TextView textView1;
	private TextView textView2;
	private TextView textView5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view);

		textView1 = findViewById(R.id.tx_1);
		textView2 = findViewById(R.id.tx_2);
		textView5 = findViewById(R.id.tx_5);

		// 中划线
		textView1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

		//下划线
		textView2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

		textView2.getPaint().setAntiAlias(true);

		textView5.setText(Html.fromHtml("<u>平凡的世界</u>"));


	}
}
