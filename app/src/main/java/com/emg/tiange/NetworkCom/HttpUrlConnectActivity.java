package com.emg.tiange.NetworkCom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emg.tiange.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectActivity extends AppCompatActivity implements View.OnClickListener {

	private Button mBtnSendReq;
	private TextView mTxRespose;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_url_connect);
		mBtnSendReq = findViewById(R.id.btn_send_request);
		mTxRespose = findViewById(R.id.tx_response);
		mBtnSendReq.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_send_request) {
			sendRequestWithHttpURLConnection();
		}
	}

	private void sendRequestWithHttpURLConnection() {
		try {
			HttpURLConnection connection = null;
			BufferedReader reader = null;
			URL url = new URL("http://www.baidu.com");
			connection = (HttpURLConnection)url.openConnection();
			//从服务器获取数据
			connection.setRequestMethod("GET");
			//连接超时
			connection.setConnectTimeout(800);
			//读取超时
			connection.setReadTimeout(800);

			InputStream inputStream = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			mTxRespose.setText(response.toString());

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
