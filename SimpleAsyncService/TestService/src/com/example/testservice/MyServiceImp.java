package com.example.testservice;


import android.os.RemoteException;

import com.example.testlib.IResponseListener;
import com.example.testlib.MyCustomType;
import com.example.testlib.MyLib.Stub;

public class MyServiceImp extends Stub{

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	} 

	@Override
	public int sumarr(int[] arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doop(MyCustomType arg0, IResponseListener arg1)
			throws RemoteException {
		int ret;
		ret = arg0.getNum1() + arg0.getNum2();
		arg1.onResponse(ret);
		// TODO Auto-generated method stub
		
	}


}
