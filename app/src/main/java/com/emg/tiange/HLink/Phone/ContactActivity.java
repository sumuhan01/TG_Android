package com.emg.tiange.HLink.Phone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.emg.tiange.R;
import com.emg.tiange.fragment.ContainerActivity;

import java.util.List;

public class ContactActivity extends AppCompatActivity {

	private ListView mListContact;
	private List<Presonal> mListPhoneData;
	private PhoneAdapter mMyAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		checPermisson();
	}


	private void checPermisson(){
		//动态获取权限
		if (ContextCompat.checkSelfPermission(ContactActivity.this, Manifest.permission.READ_CONTACTS)
			!= PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(ContactActivity.this,new String[]{Manifest.permission.READ_CONTACTS},0x201);
		} else {
			initView();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		//获取权限结果
		if (requestCode == 0x201) {
			Toast.makeText(this,"获取连续人权限开启",Toast.LENGTH_SHORT).show();
			initView();
		} else {
			Toast.makeText(this,"获取连续人权限失败",Toast.LENGTH_SHORT).show();
		}
	}

	private void initView() {
		mListContact = findViewById(R.id.list_phone);
		GetPresonal getPresonal = new GetPresonal();
		mListPhoneData = getPresonal.GetContacter(this);
		mMyAdapter = new PhoneAdapter(mListPhoneData,this);
		mListContact.setAdapter(mMyAdapter);

		mListContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:" + mListPhoneData.get(position).getmPresonNum()));
				startActivity(intent);
			}
		});

	}

}
