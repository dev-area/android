package com.mindtherobot.samples.downloadqueue;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadQueueActivity extends Activity 
	implements DownloadThreadListener, OnClickListener {
	
	private DownloadThread downloadThread;
	
	private Handler handler;
	
	private ProgressBar progressBar;
	
	private TextView statusText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Create and launch the download thread
        downloadThread = new DownloadThread(this);
        downloadThread.start();
        
        // Create the Handler. It will implicitly bind to the Looper
        // that is internally created for this thread (since it is the UI thread)
        handler = new Handler();
        
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        statusText = (TextView) findViewById(R.id.status_text);
        
        Button scheduleButton = (Button) findViewById(R.id.schedule_button);
        scheduleButton.setOnClickListener(this);
    }
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
				
		// request the thread to stop
		downloadThread.requestStop();	
    }

	// note! this might be called from another thread
	@Override
	public void handleDownloadThreadUpdate() {
		// we want to modify the progress bar so we need to do it from the UI thread 
		// how can we make sure the code runs in the UI thread? use the handler!
		handler.post(new Runnable() {
			@Override
			public void run() {
				int total = downloadThread.getTotalQueued();
				int completed = downloadThread.getTotalCompleted();
								
				progressBar.setMax(total);
				
				progressBar.setProgress(0); // need to do it due to a ProgressBar bug
				progressBar.setProgress(completed);
				
				statusText.setText(String.format("Downloaded %d/%d", completed, total));
				
				// vibrate for fun
				if (completed == total) {
					((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(100);
				}
			}
		});
	}

	@Override
	public void onClick(View source) {
		if (source.getId() == R.id.schedule_button) {
			int totalTasks = new Random().nextInt(3) + 1;
			
			for (int i = 0; i < totalTasks; ++i) {
				downloadThread.enqueueDownload(new DownloadTask());
			}
		}
	}
}