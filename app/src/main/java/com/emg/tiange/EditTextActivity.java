package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

	private Button mBtnLogin;
	private EditText mEnUserName;
	private EditText mEtPassWord;
	private String getUserName;
	private String getPassWord;

	String mStrUserName = "sumuhan";
	String mStrPassWord = "su123456";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_text);

		mBtnLogin = findViewById(R.id.btn_login);
		mEnUserName = findViewById(R.id.edt_1);
		mEtPassWord = findViewById(R.id.edt_2);

		getUserName = mEnUserName.getText().toString();
		getPassWord = mEtPassWord.getText().toString();

		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (getUserName == mStrUserName && getPassWord == mStrPassWord) {
					Toast.makeText(EditTextActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
				}
				else {
					Log.d("用户名：",getUserName);
					Log.d("密码",getPassWord);
					Toast.makeText(EditTextActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
