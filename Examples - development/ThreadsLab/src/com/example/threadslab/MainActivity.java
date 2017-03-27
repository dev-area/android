package com.example.threadslab;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	public  Handler responseHandler = new Handler() {
		@Override
		public void handleMessage(Message message) {
			switch (message.what) {
			case 1:
				tv.setText("hhh");
				Log.d("tag", "Handling 1 response" + message.obj.toString());
				break;
			case 2:
				Log.d("tag", "Handling 2 response" + message.obj.toString());
				break;
			}
		}
	};
	public  Handler responseHandler1 = new Handler() {
		@Override
		public void handleMessage(Message message) {
			switch (message.what) {
			case 3:
				tv.setText("hhh");
				Log.d("tag", "Handling 1 response" + message.obj.toString());
				break;
			case 4:
				Log.d("tag", "Handling 2 response" + message.obj.toString());
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView)findViewById(R.id.textView1);
		
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread t1=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					//	tv.setText("hhh");
						Message m=responseHandler1.obtainMessage(3, "kkkk");
						responseHandler1.sendMessage(m);
					}
				});
				t1.start();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
