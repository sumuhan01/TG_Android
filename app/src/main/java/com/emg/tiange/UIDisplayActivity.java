package com.emg.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emg.tiange.BroadcastReceiver.BroadcastActivity1;
import com.emg.tiange.GridView.GridViewActivity;
import com.emg.tiange.HanlerView.HanlerViewActivity1;
import com.emg.tiange.ListView.ListViewActivity;
import com.emg.tiange.NetworkCom.NetworkActivity;
import com.emg.tiange.TestView.DateTimeActivity;
import com.emg.tiange.fragment.ContainerActivity;
import com.emg.tiange.recyclerview.RecyclerViewActivity;

public class UIDisplayActivity extends AppCompatActivity {

	private Button mBtnLinearLayout;
	private Button mBtnRelativeLayout;
	private Button mBtnTextView;
	private Button mBtnButton;
	private Button mBtnEditText;
	private Button mBtnImageView;
	private Button mBtnScrollView;
	private Button mBtnRatioButton;
	private Button mBtnCheckBox;
	private Button mBtnListView;
	private Button mBtnGridView;
	private Button mBtnWebView;
	private Button mBtnRecycView;
	private Button mBtnDialogView;
	private Button mBtnProgressView;
	private Button mBtnFragmentView;
	private Button mBtnHandlerViwe;
	private Button mBtnBroadcastView;
	private Button mBtnNetworkView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uidisplay);

		mBtnLinearLayout = findViewById(R.id.btn_linearlayout);
		mBtnRelativeLayout = findViewById(R.id.btn_relativelayout);
		mBtnTextView = findViewById(R.id.btn_textview);
		mBtnButton = findViewById(R.id.btn_button);
		mBtnEditText = findViewById(R.id.btn_editext);
		mBtnImageView = findViewById(R.id.btn_image_view);
		mBtnScrollView = findViewById(R.id.btn_scroll_view);
		mBtnRatioButton = findViewById(R.id.btn_ratiobutton);
		mBtnCheckBox = findViewById(R.id.btn_checkbox);
		mBtnListView = findViewById(R.id.btn_list_view);
		mBtnGridView = findViewById(R.id.btn_grid_view);
		mBtnWebView = findViewById(R.id.btn_web_view);
		mBtnRecycView = findViewById(R.id.btn_recycler_view);
		mBtnDialogView = findViewById(R.id.btn_dialog_view);
		mBtnProgressView = findViewById(R.id.btn_progress_view);
		mBtnFragmentView = findViewById(R.id.btn_fragment_view);
		mBtnHandlerViwe = findViewById(R.id.btn_Handle_view);
		mBtnBroadcastView = findViewById(R.id.btn_Broadcast_view);
		mBtnNetworkView = findViewById(R.id.btn_Network_view);
		setListeners();
	}

	private void setListeners() {
		//监听Button点击
		UIDisplayActivity.OnClick onClick = new UIDisplayActivity.OnClick();
		mBtnLinearLayout.setOnClickListener(onClick);
		mBtnRelativeLayout.setOnClickListener(onClick);
		mBtnTextView.setOnClickListener(onClick);
		mBtnButton.setOnClickListener(onClick);
		mBtnEditText.setOnClickListener(onClick);
		mBtnImageView.setOnClickListener(onClick);
		mBtnScrollView.setOnClickListener(onClick);
		mBtnRatioButton.setOnClickListener(onClick);
		mBtnCheckBox.setOnClickListener(onClick);
		mBtnListView.setOnClickListener(onClick);
		mBtnGridView.setOnClickListener(onClick);
		mBtnWebView.setOnClickListener(onClick);
		mBtnRecycView.setOnClickListener(onClick);
		mBtnDialogView.setOnClickListener(onClick);
		mBtnProgressView.setOnClickListener(onClick);
		mBtnFragmentView.setOnClickListener(onClick);
		mBtnHandlerViwe.setOnClickListener(onClick);
		mBtnBroadcastView.setOnClickListener(onClick);
		mBtnNetworkView.setOnClickListener(onClick);
	}

	//实现接听器接口
	private class OnClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
				case R.id.btn_linearlayout:
					intent = new Intent(UIDisplayActivity.this, LinearLayoutActivity.class);
					break;
				case R.id.btn_relativelayout:
					intent = new Intent(UIDisplayActivity.this, RelativeLayoutActivity.class);
					break;

				case R.id.btn_textview:
					intent = new Intent(UIDisplayActivity.this, TextViewActive.class);
					break;

				case R.id.btn_button:
					intent = new Intent(UIDisplayActivity.this, ButtonActivity.class);
					break;

				case R.id.btn_editext:
					intent =  new Intent(UIDisplayActivity.this,EditTextActivity.class);
					break;

				case R.id.btn_image_view:
					intent =  new Intent(UIDisplayActivity.this,ImageViewActivity.class);
					break;

				case R.id.btn_scroll_view:
					intent =  new Intent(UIDisplayActivity.this,ScrollViewActivity.class);
					break;

				case R.id.btn_ratiobutton:
					intent =  new Intent(UIDisplayActivity.this, RadioButtonActivity.class);
					break;

				case R.id.btn_checkbox:
					intent = new Intent(UIDisplayActivity.this,CheckBoxActivity.class);
					break;

				case R.id.btn_list_view:
					intent = new Intent(UIDisplayActivity.this, ListViewActivity.class);
					break;

				case R.id.btn_grid_view:
					intent = new Intent(UIDisplayActivity.this, GridViewActivity.class);
					break;

				case R.id.btn_web_view:
					intent = new Intent(UIDisplayActivity.this, WebViewActivity.class);
					break;

				case R.id.btn_recycler_view:
					intent = new Intent(UIDisplayActivity.this, RecyclerViewActivity.class);
					break;

				case R.id.btn_dialog_view:
					intent = new Intent(UIDisplayActivity.this, DialogViewActivity.class);
					break;

				case R.id.btn_progress_view:
					intent = new Intent(UIDisplayActivity.this, ProgressActivity.class);
					break;

				case R.id.btn_fragment_view:
					intent = new Intent(UIDisplayActivity.this, ContainerActivity.class);
					break;

				case R.id.btn_Handle_view:
					intent = new Intent(UIDisplayActivity.this, HanlerViewActivity1.class);
					break;

				case R.id.btn_Broadcast_view:
					intent = new Intent(UIDisplayActivity.this, BroadcastActivity1.class);
					break;

				case R.id.btn_Network_view:
					intent = new Intent(UIDisplayActivity.this, NetworkActivity.class);
					break;

				default:
					break;
			}
			startActivity(intent);
		}
	}
}
