package com.example.testjni;

public class Nlib {
	public static native int add(int a,int b);
	public native int sub(int a,int b);
	
	private int getNum(int a)
	{
		return a+100;
	}
	static 
	{
		System.loadLibrary("testJNI");
	}
}
