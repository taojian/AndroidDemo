package com.tj.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		Log.i("LaunchMode", "---onCreate---Activity2.taskId------"+getTaskId());
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("LaunchMode", "---onNewIntent---Activity2.taskId------"+getTaskId());
		super.onNewIntent(intent);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onTouchEvent----Activity2---");
		Intent it = new Intent();
		it.setClass(this, Activity1.class);
		startActivity(it);
		return super.onTouchEvent(event);
	}
	
	
}
