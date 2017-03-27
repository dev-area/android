package com.example.testjni;

import android.os.Bundle;
import android.os.Debug;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Debug.waitForDebugger();
		
		int res=Nlib.add(10, 20);
//		Nlib n1=new Nlib();
//		res = n1.sub(10,20);
		
		Toast.makeText(this, "res:"+res, Toast.LENGTH_LONG).show();
		
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int res1=Nlib.add(10, 40);
				Toast.makeText(MainActivity.this, "res:"+res1, Toast.LENGTH_LONG).show();
				
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
