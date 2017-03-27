package com.android.fibappservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.fibservice.*;

class IFibServiceImpl extends IFibService.Stub {

  public static native long fibNI(int a);
  public static native long fibNR(int a);

  public long fibi(int a) {

    return fibNI(a) ;                           
  }

  public long fibr(int a) {

    return fibNR(a) ;                           
  }

  static 
  {
	System.loadLibrary("fib_jni");
  }
}












