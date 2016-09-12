package com.tj.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class Activity3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity3);
		Log.i("LaunchMode", "------Activity3.taskId------"+getTaskId());
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onNewIntent----Activity3---");
		super.onNewIntent(intent);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onTouchEvent----Activity3---");
		Intent it = new Intent();
		it.setClass(this, Activity1.class);
		startActivity(it);
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onDestroy----Activity3---");
		super.onDestroy();
	}
	
	
	
	
}
