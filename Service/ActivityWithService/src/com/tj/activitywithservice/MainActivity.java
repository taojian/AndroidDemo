package com.tj.activitywithservice;

import com.tj.activitywithservice.BoundService.LocalBinder;

import android.support.v7.app.ActionBarActivity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private final String TAG = "MainActivity";
	private Button btStart;
	private Button btStop;
	private Intent service; 
	private Service mService;
	private boolean mBound;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btStart = (Button)this.findViewById(R.id.bt_start);
		btStart.setOnClickListener(this);
		btStop = (Button) this.findViewById(R.id.bt_stop);
		btStop.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.bt_start:
			service = new Intent(this, BoundService.class);
//			this.startService(service);
			this.bindService(service, connection, Context.BIND_AUTO_CREATE);
			break;
		case R.id.bt_stop:
//			this.stopService(service);
			this.unbindService(connection);
//			this.finish();
			break;
			
		default:
			break;
		}
	}
	
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			Log.i(TAG, "---tj------onServiceDisconnected---");
			mBound = false;
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// TODO Auto-generated method stub
			Log.i(TAG, "---tj------onServiceConnected---");
			LocalBinder localBinder = (LocalBinder) service;
			mService = localBinder.getService();
			mBound = true;
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
