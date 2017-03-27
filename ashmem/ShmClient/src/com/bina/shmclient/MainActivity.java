package com.bina.shmclient;

import com.bina.utils.IShmService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
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

public class MainActivity extends Activity implements OnClickListener,
ServiceConnection {


	private Button button;

	private IShmService service;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		this.button = (Button) super.findViewById(R.id.button1);
		this.button.setOnClickListener(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (!super.bindService(new Intent("com.bina.utils.ShmService"), this,
				BIND_AUTO_CREATE)) {
			Log.d("err", "Failed to bind");
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		super.unbindService(this);
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		this.service = IShmService.Stub.asInterface(service); 
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		this.service = null;
	}

	public void onClick(View v) {
		String res="";
		try {
			ParcelFileDescriptor p = service.getFD("hhh");
			
			ShmClientLib.init(p.getFd());
			Toast.makeText(this,  res + ShmClientLib.getNum(10), Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
