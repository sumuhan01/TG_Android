package com.emg.tiange.Message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.emg.tiange.R;

public class MessagDisplayActivity extends AppCompatActivity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messag_display);
		textView = findViewById(R.id.msg_display);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		textView.setText(bundle.getString("msg_body"));
	}
}
