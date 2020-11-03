/**
 * Fragment 有自己的生命周期
 * Fragment依赖于Activity
 * Fragment通过 getActivity() 可以获取所在的Activity；
 * Activity通过FragmentManager的 findFragmentById()或findFragmentByTag 获取Fragment
 * Fragment和Activity是多对多的关系
 */

package com.emg.tiange.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emg.tiange.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.OnMessageClick {
	private AFragment aFragment;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_container);

		textView = findViewById(R.id.tv_title);

		//创建aFragment对象
		// 调用getSupportFragment方法里的beginTransaction（）方法去向指定容器添加aFragament
		//最后调用commitAllowingStateLoss()方法
		aFragment = AFragment.newInstance("Hello AFragment");

		//给fragment添加一个a标识符，方便后面调用
		getSupportFragmentManager().beginTransaction().add(R.id.f1_container,aFragment,"a").commitAllowingStateLoss();
	}

	@Override
	public void onClick(String text) {
		textView.setText(text);
	}

}
