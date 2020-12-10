package com.emg.tiange.Message;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetMessageInfo {
	//获取手机短信的URI
	final String SMS_URI_ALL = "content://sms/"; // 所有短信
	final String SMS_URI_INBOX = "content://sms/inbox"; // 收件箱
	final String SMS_URI_SEND = "content://sms/sent"; // 已发送
	final String SMS_URI_DRAFT = "content://sms/draft"; // 草稿
	final String SMS_URI_OUTBOX = "content://sms/outbox"; // 发件箱
	final String SMS_URI_FAILED = "content://sms/failed"; // 发送失败
	final String SMS_URI_QUEUED = "content://sms/queued"; // 待发送列表

	public List<MessageInfo> GetMessage(Context context) {
		List<MessageInfo> messageInfoList = new ArrayList<>();
		try {
			/**
			 获取短信的各种信息 ，短信数据库sms表结构如下：
			 _id：短信序号，如100　　
		 　 　 thread_id：对话的序号，如100，与同一个手机号互发的短信，其序号是相同的            　　
		 　  　address：发件人地址，即手机号，如+8613811810000            　　            　　
		 　  　date：日期，long型，如1256539465022，可以对日期显示格式进行设置            　　        　　
		 　  　read：是否阅读0为未读            　　
		 　  　status：短信状态-1表示短信已被接收            　　
		 　  　type：短信类型1表示接收到的短信            　　
		 　  　body：短信具体内容            　　
		 　  　service_center：短信服务中心号码编号，如+8613800755500
			 */
			ContentResolver contentResolver = context.getContentResolver();
			String[] project = new String[]{"_id", "address","body",
					"date", "type"};
			Uri uri = Uri.parse(SMS_URI_ALL);

			//获取数据库短信数据
			Cursor cursor = contentResolver.query(uri,project,null,null,"date desc");

			if (cursor.moveToFirst()) {
				String msgPhoneNum;
				String msgBody;
				String msgDate;
				String msgType;
				int msgPhoneNumIndex = cursor.getColumnIndex("address");
				int msgBodyIndex = cursor.getColumnIndex("body");
				int msgDateIndex = cursor.getColumnIndex("date");
				int msgTypeIndex = cursor.getColumnIndex("type");

				while (cursor.moveToNext()) {
					//设置日期显示格式
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date(Long.parseLong(cursor.getString(msgDateIndex)));

					MessageInfo messageInfo = new MessageInfo();
					messageInfo.setMsgBody(cursor.getString(msgBodyIndex));
					messageInfo.setMsgPhone(cursor.getString(msgPhoneNumIndex));
					messageInfo.setMsgType(cursor.getInt(msgTypeIndex));
					messageInfo.setMsgDate(dateFormat.format(date));
					messageInfoList.add(messageInfo);
				}
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageInfoList;
	}
}
