package com.emg.tiange.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emg.tiange.R;

public class AFragment extends Fragment {
	private TextView textView;
	private BFragment bFragment;
	private Button mBtnChange;
	private Button mBtnChangeText;
	private Button mBtnChangeActivity;
	OnMessageClick listener;

	public static AFragment newInstance(String title) {
		AFragment fragment = new AFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}

	public interface OnMessageClick {
		void onClick(String text);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		//创建布局视图
		View view = inflater.inflate(R.layout.layout_fragment_a,null);
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		//当View创建后，这里有个回调方法
		super.onViewCreated(view, savedInstanceState);
		textView = view.findViewById(R.id.tv_title);
		mBtnChange = view.findViewById(R.id.btn_change);
		mBtnChangeText = view.findViewById(R.id.btn_change2);
		mBtnChangeActivity = view.findViewById(R.id.btn_change_activity);

		mBtnChangeActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onClick("LOL SN 夺冠");
			}
		});

		mBtnChange.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (bFragment == null) {
					bFragment = new BFragment();
				}
				//获取表示符a用来表示aFragment是否存
				Fragment fragment = getFragmentManager().findFragmentByTag("a");
				if (fragment != null) {
					//如果aFragment存在，就先把aFragment隐藏在回收栈，然后在替换bFragment
					getFragmentManager().beginTransaction().hide(fragment).replace(R.id.f1_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
				} else getFragmentManager().beginTransaction().replace(R.id.f1_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
			}
		});

		mBtnChangeText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setText("显示更新");
			}
		});

		if (getArguments() != null) {
			textView.setText(getArguments().getString("title"));
		}
	}

	@Override
	public void onAttach(@NonNull Context context) {
		//当Fragment跟Activity发生关联时调用
		super.onAttach(context);
		listener = (OnMessageClick)context;
		Log.d("AFragment","onAttach");
	}

	@Override
	public void onDestroy() {
		//取消异步
		super.onDestroy();
		Log.d("AFragment","onDestroy");
	}

	@Override
	public void onDetach() {
		//当Fragment跟Activity解除关联时调用
		super.onDetach();
		Log.d("AFragment","onDetach");
	}
}
