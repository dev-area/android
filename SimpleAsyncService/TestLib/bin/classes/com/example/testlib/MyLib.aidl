package com.example.testlib;

import com.example.testlib.MyCustomType;
import com.example.testlib.IResponseListener;



interface MyLib
{
	int add(int a,int b);
	int sub(int a,int b);
	int sumarr(in int []arr);
	oneway void doop(in MyCustomType t,
		IResponseListener resp);
}