package com.example.cpptest;

import java.nio.ByteBuffer;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		long r=FibLib.fibNR(20);
		Toast.makeText(this, "res:" + r, Toast.LENGTH_LONG).show();
		ByteBuffer ret=FibLib.getBuf();
		Log.d("val", "byte:" + ret.get(10));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
