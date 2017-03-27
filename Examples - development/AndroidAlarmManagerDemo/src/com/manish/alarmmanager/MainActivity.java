package com.manish.alarmmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author manish
 *
 */

public class MainActivity extends Activity implements OnClickListener{

	Button btnStartAlarm,btnStopAlarm;
	Context context;
	static PendingIntent pendingIntent;
	static AlarmManager alarmManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=MainActivity.this;
		

		Intent intentsOpen = new Intent(this, AlarmReceiver.class);
		
		intentsOpen.setAction("com.manish.alarm.ACTION");
		pendingIntent = PendingIntent.getBroadcast(this,111, intentsOpen, 0);
		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		
		btnStartAlarm=(Button)findViewById(R.id.button1);
		btnStopAlarm=(Button)findViewById(R.id.button2);
		
		btnStartAlarm.setOnClickListener(this);
		btnStopAlarm.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnStartAlarm){
			fireAlarm();
		}
		if(v==btnStopAlarm){
			stopAlarm();
		}
	}
	public void fireAlarm() {
		/**
		 * call broadcost reciver
		 */
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 10000, pendingIntent);
		
		
	}
	public void stopAlarm(){
				alarmManager.cancel(pendingIntent);
		
		
		
	}


}
