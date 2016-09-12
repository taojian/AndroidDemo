package com.tj.activitywithservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/*
 *查看IntentService源码能看出来IntentService就是一次性service，执行完onHandleIntent方法就自杀
 *一般都是用于startService的启动方式
 *仔细阅读IntentService源码，里面还是有很多可取之处
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
