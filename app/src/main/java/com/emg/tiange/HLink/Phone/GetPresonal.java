package com.emg.tiange.HLink.Phone;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class GetPresonal {
	private final String NUM = ContactsContract.CommonDataKinds.Phone.NUMBER;
	private final String NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
	//联系人的URI
	private Uri PHONE_URI = Uri.parse(ContactsContract.CommonDataKinds.Phone.PHOTO_URI);

	public GetPresonal() {

	}

	public List<Presonal> GetContacter(Context context){
		List<Presonal> phoneData = new ArrayList<>();
		//从数据库中获取连续信息
//		ContentResolver contentResolver = context.getContentResolver();
//		Cursor cursor = contentResolver.query(PHONE_URI,null,null,null,null);
		Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		String nPhoneName;
		String nPhoneNum;
		while (cursor.moveToNext()) {
			nPhoneName = cursor.getString(cursor.getColumnIndex(NAME));
			nPhoneNum = cursor.getString(cursor.getColumnIndex(NUM));
			Presonal presonal = new Presonal(nPhoneName,nPhoneNum);
			phoneData.add(presonal);
		}
		cursor.close();
		return  phoneData;
	}
}
