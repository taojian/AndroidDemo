package com.tj.activitywithservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/*
 *�鿴IntentServiceԴ���ܿ�����IntentService����һ����service��ִ����onHandleIntent��������ɱ
 *һ�㶼������startService��������ʽ
 *��ϸ�Ķ�IntentServiceԴ�룬���滹���кܶ��ȡ֮��
 */
public class HelloIntentService extends IntentService{

	private final String TAG = "HelloIntentService";
	public HelloIntentService() {
		super("HelloIntentService");
		// TODO Auto-generated constructor stub
		Log.i(TAG, "----tj------HelloIntentService----init--");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i(TAG, "---tj---onHandleIntent------");
		 long endTime = System.currentTimeMillis() + 50*1000;
	      while (System.currentTimeMillis() < endTime) {
	          synchronized (this) {
	              try {
	                  wait(endTime - System.currentTimeMillis());
	              } catch (Exception e) {
	              }
	          }
	      }
	}

}
