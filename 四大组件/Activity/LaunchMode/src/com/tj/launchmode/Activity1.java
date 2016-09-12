package com.tj.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class Activity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		Log.i("LaunchMode", "---onCreate---Activity1.taskId------"+getTaskId());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onTouchEvent----Activity1---");
		Intent it = new Intent();
		it.setClass(this, Activity3.class);
		startActivity(it);
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("LaunchMode", "------onDestroy----Activity1---");
		super.onDestroy();
	}
	
}
