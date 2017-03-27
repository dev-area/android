package com.android.sampappservice;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;
import com.android.sampservice.ISampService;

public class SampServiceApp extends Application {
  private static final String REMOTE_SERVICE_NAME = ISampService.class.getName();
  private ISampServiceImpl serviceImpl;

  public void onCreate() {
    super.onCreate();
    this.serviceImpl = new ISampServiceImpl();
    ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
  }

  public void onTerminate() {
    super.onTerminate();
  }
}

