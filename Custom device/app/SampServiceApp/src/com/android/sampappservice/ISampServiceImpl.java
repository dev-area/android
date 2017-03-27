package com.android.sampappservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.sampservice.*;

class ISampServiceImpl extends ISampService.Stub {


  public int add(int a,int b) {

    return a+b ;                           
  }

  public int sub(int a,int b) {
    return a-b;                           
  }


}
