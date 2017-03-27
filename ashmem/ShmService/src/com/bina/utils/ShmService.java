package com.bina.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ShmService extends Service{
	private ShmServiceImp service;
 
	@Override
	public void onCreate() {
		super.onCreate();
		this.service = new ShmServiceImp();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return this.service;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
