package com.android.fibservice;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog; 
import java.util.HashSet;
import java.util.Set;

public class FibManager {
  private static final String REMOTE_SERVICE_NAME = IFibService.class.getName();

  
  private final IFibService service;
  
  public static FibManager getInstance() {
    return new FibManager();
  }

    public long fibi(int a) 
    {
	try
	{
		return service.fibi(a);
	}catch(Exception ec){}
	return 0;
    }

   public long fibr(int a) 
    {
	try
	{
		return service.fibr(a);
	}catch(Exception ec){}
	return 0;
    }

  private FibManager() {
    this.service = IFibService.Stub.asInterface(
      ServiceManager.getService(REMOTE_SERVICE_NAME));             
    if (this.service == null) {
      throw new IllegalStateException("Failed to find IFibService by name [" + REMOTE_SERVICE_NAME + "]");
    }
  }   
  
}
