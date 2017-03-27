package com.android.fibappservice;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;
import com.android.fibservice.IFibService;
 
public class FibServiceApp extends Application {
  private static final String REMOTE_SERVICE_NAME = IFibService.class.getName();
  private IFibServiceImpl serviceImpl;

  public void onCreate() {
    super.onCreate();
    this.serviceImpl = new IFibServiceImpl();
    ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
  }

  public void onTerminate() {
    super.onTerminate();
  }
}

