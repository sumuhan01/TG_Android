package com.emg.tiange.MingRi.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveActivity extends BroadcastReceiver {
	private static final String ACTION1 = "wangzhe";
	private static final String ACTION2 = "LOL";
	public ReceiveActivity() {

	}
	@Override

	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(ACTION1)) {
			Toast.makeText(context,"王者荣耀",Toast.LENGTH_SHORT).show();
		} else if (intent.getAction().equals(ACTION2)) {
			Toast.makeText(context,"英雄联盟",Toast.LENGTH_SHORT).show();
		}

	}
}
