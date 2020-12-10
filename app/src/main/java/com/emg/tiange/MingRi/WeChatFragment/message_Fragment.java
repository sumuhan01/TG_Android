package com.emg.tiange.MingRi.WeChatFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emg.tiange.R;

public class message_Fragment extends Fragment {
	public message_Fragment(){

	}
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View findView = inflater.inflate(R.layout.message_wechat,null);
		return findView;
	}
}
