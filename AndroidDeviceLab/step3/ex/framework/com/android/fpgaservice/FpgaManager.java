package com.android.fpgaservice;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import java.util.HashSet;
import java.util.Set;

public class FpgaManager {
  private static final String REMOTE_SERVICE_NAME = IFpgaService.class.getName();


  private final IFpgaService service;

  public static FpgaManager getInstance() {
    return new FpgaManager();
  }

//TODO: implement adapter for all functions

  private FpgaManager() {
    this.service = IFpgaService.Stub.asInterface(
      ServiceManager.getService(REMOTE_SERVICE_NAME));
    if (this.service == null) {
      throw new IllegalStateException("Failed to find IFpgaService by name [" + REMOTE_SERVICE_NAME + "]");
    }
  }

}
