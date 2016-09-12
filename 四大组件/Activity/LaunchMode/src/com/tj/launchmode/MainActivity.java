package com.tj.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("LaunchMode", "----MainActivity.taskId----"+this.getTaskId());
		Button bt1 = (Button)this.findViewById(R.id.bt1);
		bt1.setOnClickListener(this);
		Button bt2 = (Button)this.findViewById(R.id.bt2);
		bt2.setOnClickListener(this);
		Button bt3 = (Button)this.findViewById(R.id.bt3);
		bt3.setOnClickListener(this);
		Button bt4 = (Button)this.findViewById(R.id.bt4);
		bt4.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
			case R.id.bt1:
				Intent it1 = new Intent();
				it1.setClass(this, Activity1.class);
				startActivity(it1);
				break;
			case R.id.bt2:
				Intent it2 = new Intent();
				it2.setClass(this, Activity2.class);
				startActivity(it2);
				break;
			case R.id.bt3:
				Intent it3 = new Intent();
				it3.setClass(this, Activity3.class);
				startActivity(it3);
				break;
			case R.id.bt4:
				Intent it4 = new Intent();
				it4.setClass(this, Activity4.class);
				startActivity(it4);
				break;
			default:
				break;
		
		}
	}
	
	
}
