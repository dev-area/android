package com.manish.alarmmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OutPut extends Activity {
	TextView textmessage;
	String stringValue;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);

		textmessage = (TextView) findViewById(R.id.textView1);

		Intent intent = getIntent();
		stringValue = intent.getStringExtra("content");
		textmessage.setText(stringValue);
		System.out.println(stringValue);

	}
}