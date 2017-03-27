package com.example.alarmtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmEvent extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, 
			Intent intent) {
		// TODO Auto-generated method stub
		Log.d("mytag","mymsg");
	}

}
