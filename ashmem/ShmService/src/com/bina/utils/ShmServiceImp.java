package com.bina.utils;

import java.io.FileDescriptor;
import java.io.IOException;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public class ShmServiceImp extends IShmService.Stub{

	@Override
	public ParcelFileDescriptor getFD(String name) throws RemoteException {
		try {
			int fd = ShmLib.getFD(name);
			ParcelFileDescriptor ret=ParcelFileDescriptor.fromFd(fd);
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public int getNum(int pos) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNum(int pos, int n) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
