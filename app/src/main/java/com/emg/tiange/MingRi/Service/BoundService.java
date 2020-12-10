package com.emg.tiange.MingRi.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoundService extends Service {
	public BoundService() {
	}

	public class MyBinder extends Binder {
		public BoundService getService() {
			return BoundService.this;  //通过MyBinder类中的的getService获取BouderService对象
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		return new MyBinder();
	}

	//生成随机数
	public List getRandomNumber() {
		List resArr = new ArrayList();
		String strNum;
		for (int i = 0;i < 7; i++) {
			int num = new Random().nextInt(33) + 1; //1~33 随机数
			if (num < 10) {
				strNum = "0" + String.valueOf(num);
			} else {
				strNum = String.valueOf(num);
			}
			resArr.add(strNum);
		}
		return resArr;
	}

	@Override
	public void onDestroy() {  //销毁service
		super.onDestroy();
	}
}
