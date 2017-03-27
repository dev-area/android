package com.example.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service{

	MyServiceImp imp;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return imp;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		imp = new MyServiceImp();
	}

}
