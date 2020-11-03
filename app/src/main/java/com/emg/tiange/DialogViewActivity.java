/*
* AlertDialog 警告对话框不能直接new出来，需要通过设置静态内部类来实现:public static class Buidler
* 基本步骤：
* 	1.创建AlertDialog.Buidler基本对象
*   2.使用SetIcon、SetTitle或者使用SetCustomTitle设置标题
*   3.设置对话框内容，使用setMessage来指定其是显示内容
*   4调用setPositive/setNagative/NeurtralButton设置，确定、取消、中立按钮
*   5.调用create()这个方法创建对象，在用.show()显示出来
* */

package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogViewActivity extends AppCompatActivity {

	private Button mBtnDlg1,mBtnDlg2,mBtnDlg3,mBtnDlg4,mBtnDlg5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_view);

		mBtnDlg1 = findViewById(R.id.btn_dialog1);
		mBtnDlg2 = findViewById(R.id.btn_dialog2);
		mBtnDlg3 = findViewById(R.id.btn_dialog3);
		mBtnDlg4 = findViewById(R.id.btn_dialog4);
		mBtnDlg5 = findViewById(R.id.btn_dialog5);

		//增加监听事件
		OnClick onClick = new OnClick();
		mBtnDlg1.setOnClickListener(onClick);
		mBtnDlg2.setOnClickListener(onClick);
		mBtnDlg3.setOnClickListener(onClick);
		mBtnDlg4.setOnClickListener(onClick);
		mBtnDlg5.setOnClickListener(onClick);
	}

	class OnClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btn_dialog1:
					//普通弹框
					AlertDialog.Builder builder = new AlertDialog.Builder(DialogViewActivity.this);
					builder.setTitle("请回答").setMessage("你喜欢android吗？").setIcon(R.drawable.username)
							.setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									Toast.makeText(DialogViewActivity.this,"真的吗？",Toast.LENGTH_SHORT).show();
								}
							})
							.setNeutralButton("还行", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									Toast.makeText(DialogViewActivity.this,"你确定吗？",Toast.LENGTH_SHORT).show();
								}
							})
							.setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									Toast.makeText(DialogViewActivity.this,"为什么？",Toast.LENGTH_SHORT).show();
								}
							}).show();
					break;

				case R.id.btn_dialog2:
					final String[] mSexStr = new String[]{"男", "女"};
					AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogViewActivity.this);
					builder2.setTitle("请选择性别！").setItems(mSexStr, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(DialogViewActivity.this, mSexStr[which],Toast.LENGTH_SHORT).show();
						}
					}).show();
					break;

				case R.id.btn_dialog3:
					//单选
					final String[] mSexStr3 = new String[]{"男","女"};
					AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogViewActivity.this);
					builder3.setTitle("请选择性别！").setSingleChoiceItems(mSexStr3, 0, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(DialogViewActivity.this, mSexStr3[which],Toast.LENGTH_SHORT).show();
							dialog.dismiss();
					}
					}).setCancelable(false).show();
					break;

				case R.id.btn_dialog4:
					//复选
					final String[] arry4 = new String[]{"吃鸡","王者","LOL"};
					final boolean[] isCheckd = new boolean[]{false,true,false};
					AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogViewActivity.this);
					builder4.setTitle("喜欢的游戏？").setMultiChoiceItems(arry4, isCheckd, new DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							Toast.makeText(DialogViewActivity.this,arry4[which]+": " + isCheckd[which],Toast.LENGTH_SHORT).show();
						}
					}).setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					break;

				case R.id.btn_dialog5:
					AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogViewActivity.this);
					View logView = LayoutInflater.from(DialogViewActivity.this).inflate(R.layout.layout_dialog, null);
					TextView userName = logView.findViewById(R.id.et_usename);
					TextView passWord = logView.findViewById(R.id.et_password);
					Button btnLoging = logView.findViewById(R.id.btn_login);
					btnLoging.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							Toast.makeText(DialogViewActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
						}
					});
					builder5.setTitle("请先输入登录").setView(logView).show();
					break;

					default:
						break;
			}
		}
	}
}
