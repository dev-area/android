package com.example.testclient;

import com.example.testlib.IResponseListener;
import com.example.testlib.MyCustomType;
import com.example.testlib.MyLib;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
	implements ServiceConnection{
	IResponseListener res = new IResponseListener.Stub() {
		
		@Override
		public void onResponse(int arg0) throws RemoteException {
			// TODO Auto-generated method stub
			Log.d("result", "res:" + arg0);
		}
	};
	

	MyLib mylib;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					MyCustomType op = new MyCustomType();
					op.setNum1(10);
					op.setNum2(20);
					mylib.doop(op,res);
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		bindService(new Intent("com.example.testservice.MyService"), 
				this, BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		// TODO Auto-generated method stub
		mylib = MyLib.Stub.asInterface(service);
		
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub
		
	}

}
