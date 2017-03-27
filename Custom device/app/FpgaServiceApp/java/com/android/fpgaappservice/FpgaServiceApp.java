package com.android.fpgaappservice;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;
import com.android.fpgaservice.IFpgaService;
 
public class FpgaServiceApp extends Application {
  private static final String REMOTE_SERVICE_NAME = IFpgaService.class.getName();
  private IFpgaServiceImpl serviceImpl;

  public void onCreate() {
    super.onCreate();
    this.serviceImpl = new IFpgaServiceImpl();
    ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
  }

  public void onTerminate() {
    super.onTerminate();
  }
}

