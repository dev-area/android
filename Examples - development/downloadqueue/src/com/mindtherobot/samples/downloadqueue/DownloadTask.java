package com.mindtherobot.samples.downloadqueue;

import java.util.Random;

import android.util.Log;

/**
 * This is not a real download task.
 * It just sleeps for some random time when it's launched. 
 * The idea is not to require a connection and not to eat it.
 * 
 */
public class DownloadTask implements Runnable {

	private static final String TAG = DownloadTask.class.getSimpleName();
	
	private static final Random random = new Random();
	
	private int lengthSec;
	
	public DownloadTask() {
		lengthSec = random.nextInt(3) + 1;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(lengthSec * 1000);
			
			// it's a good idea to always catch Throwable
			// in isolated "codelets" like Runnable or Thread
			// otherwise the exception might be sunk by some
			// agent that actually runs your Runnable - you
			// never know what it might be.
		} catch (Throwable t) {
			Log.e(TAG, "Error in DownloadTask", t);
		}
	}
}
