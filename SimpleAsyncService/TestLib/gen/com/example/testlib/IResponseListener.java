/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/developer/workspace1/TestLib/src/com/example/testlib/IResponseListener.aidl
 */
package com.example.testlib;
public interface IResponseListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.testlib.IResponseListener
{
private static final java.lang.String DESCRIPTOR = "com.example.testlib.IResponseListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.testlib.IResponseListener interface,
 * generating a proxy if needed.
 */
public static com.example.testlib.IResponseListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.testlib.IResponseListener))) {
return ((com.example.testlib.IResponseListener)iin);
}
return new com.example.testlib.IResponseListener.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onResponse:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onResponse(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.testlib.IResponseListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void onResponse(int response) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(response);
mRemote.transact(Stub.TRANSACTION_onResponse, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onResponse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onResponse(int response) throws android.os.RemoteException;
}
