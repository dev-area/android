package com.example.alarmtest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent in=new Intent(this,AlarmEvent.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, in, 0);
		
		
		AlarmManager man=(AlarmManager)getSystemService(ALARM_SERVICE);
		
		man.setRepeating(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis(), 2000, pi);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
