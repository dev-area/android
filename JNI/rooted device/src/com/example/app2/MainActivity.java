package com.example.app2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Debug;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int res2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Debug.waitForDebugger();
//		res2=add(10,20);

		final TextView tv=(TextView)findViewById(R.id.tv1);
		Button b1=(Button)findViewById(R.id.button1);
				b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Process p=Runtime.getRuntime().exec("su");
					//p.waitFor();
					Shell sh=new Shell();
					String res=sh.sendShellCommand(new String[]{"su","-c","data/data/com.example.app2/lib/libapp.so"});
					Log.d("aaa", res);
					//return;
				} catch (Exception e) {
					Log.d("aaa", "error run su");
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				
				int res=add(10,20);
				tv.setText("res:" + res );
			
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public static native int add(int a,int b);
	
	static {
		System.loadLibrary("mytest");
	}
	
}







