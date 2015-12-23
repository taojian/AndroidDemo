package com.tj.activitywithservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BoundService extends Service{

	private IBinder mLocalBinder = new LocalBinder(); 
	
	public class LocalBinder extends Binder{
		public Service getService(){
			return BoundService.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mLocalBinder;
	}

	
}
