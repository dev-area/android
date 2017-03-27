package com.android.fpgaappservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.fpgaservice.*;

class IFpgaServiceImpl extends IFpgaService.Stub {

  public static native int getVal();
//  public static native void init();

  public int getval() {

    return getVal() ;                           
  }

  static 
  {
	System.loadLibrary("fpga_jni");
//	init();
  }
}












