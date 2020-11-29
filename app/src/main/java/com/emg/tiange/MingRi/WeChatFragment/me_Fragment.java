package com.emg.tiange.MingRi.WeChatFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emg.tiange.R;

public class me_Fragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View meView = inflater.inflate(R.layout.me_wechat,container,false);
		return meView;
	}
}
