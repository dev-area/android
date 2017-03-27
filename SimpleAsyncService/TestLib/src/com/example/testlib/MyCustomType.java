package com.example.testlib;

import android.os.Parcel;
import android.os.Parcelable;

public class MyCustomType implements Parcelable{

	int num1,num2;
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(num1);
		dest.writeInt(num2);
	}
	public static final Parcelable.Creator<MyCustomType> CREATOR = 
			new Parcelable.Creator<MyCustomType>() {
		public MyCustomType createFromParcel(Parcel in) {
			MyCustomType ret = new MyCustomType();
			ret.num1 = in.readInt();
			ret.num2 = in.readInt();
			return ret;
		}

		public MyCustomType[] newArray(int size) {
			return new MyCustomType[size];
		}
	};

}
