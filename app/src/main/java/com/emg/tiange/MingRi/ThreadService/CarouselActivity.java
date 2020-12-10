package com.emg.tiange.MingRi.ThreadService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.emg.tiange.R;

public class CarouselActivity extends AppCompatActivity {

	final int FLAG_MSG = 0x02;
	private Message message;
	private ViewFlipper viewFlipper;
	private int imageList [] = new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
			R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carousel);
		viewFlipper = findViewById(R.id.view_flipper);

		for(int i = 0;i < imageList.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(imageList[i]);
			viewFlipper.addView(imageView);
		}

		message = Message.obtain();
		message.what = FLAG_MSG;
		handler.sendMessage(message);
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(@NonNull Message msg) {
			if(msg.what == FLAG_MSG) {
				viewFlipper.showPrevious();
			}
			message = handler.obtainMessage(FLAG_MSG);
			handler.sendMessageDelayed(message,1000);
		}
	};
}
