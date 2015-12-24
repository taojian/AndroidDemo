package com.tj.activitywithservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service{

	private final String TAG = "BoundService";
	private IBinder mLocalBinder = new LocalBinder(); 
	
	public class LocalBinder extends Binder{
		public Service getService(){
			return BoundService.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "----tj-----onBind---");
		return mLocalBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.i(TAG, "----tj-----onCreate---");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "----tj-----onDestroy---");
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		super.onRebind(intent);
		Log.i(TAG, "----tj-----onRebind---");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "----tj-----onUnbind---");
		return super.onUnbind(intent);
	}

	
	
}
