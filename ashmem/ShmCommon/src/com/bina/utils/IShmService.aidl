package com.bina.utils;


import android.os.ParcelFileDescriptor;

interface IShmService
{
	ParcelFileDescriptor getFD(in String name);
	void setNum(int pos,int num);
	int getNum(int pos);
}