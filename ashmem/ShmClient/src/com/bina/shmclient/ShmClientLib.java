package com.bina.shmclient;

public class ShmClientLib {
	static {
		System.loadLibrary("ShmClient");
	}
	
	public static native void setNum(int pos,int num);
	public static native int getNum(int pos);
	public static native void init(int fd);

}
