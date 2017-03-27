package com.bina.utils;

import android.os.ParcelFileDescriptor;

public class ShmLib {
	static {
		System.loadLibrary("Shm");
	}
	
	public static native void setNum(int pos,int num);
	public static native int getNum(int pos);
	public static native int getFD(String name);
}
