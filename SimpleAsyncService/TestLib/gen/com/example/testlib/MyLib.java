/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/developer/workspace1/TestLib/src/com/example/testlib/MyLib.aidl
 */
package com.example.testlib;
public interface MyLib extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.testlib.MyLib
{
private static final java.lang.String DESCRIPTOR = "com.example.testlib.MyLib";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.testlib.MyLib interface,
 * generating a proxy if needed.
 */
public static com.example.testlib.MyLib asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.testlib.MyLib))) {
return ((com.example.testlib.MyLib)iin);
}
return new com.example.testlib.MyLib.Stub.Proxy(obj);
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
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.add(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_sub:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.sub(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_sumarr:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
int _result = this.sumarr(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_doop:
{
data.enforceInterface(DESCRIPTOR);
com.example.testlib.MyCustomType _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.testlib.MyCustomType.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.example.testlib.IResponseListener _arg1;
_arg1 = com.example.testlib.IResponseListener.Stub.asInterface(data.readStrongBinder());
this.doop(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.testlib.MyLib
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
@Override public int add(int a, int b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int sub(int a, int b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
mRemote.transact(Stub.TRANSACTION_sub, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int sumarr(int[] arr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(arr);
mRemote.transact(Stub.TRANSACTION_sumarr, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void doop(com.example.testlib.MyCustomType t, com.example.testlib.IResponseListener resp) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((t!=null)) {
_data.writeInt(1);
t.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((resp!=null))?(resp.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_doop, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_sub = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sumarr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_doop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public int add(int a, int b) throws android.os.RemoteException;
public int sub(int a, int b) throws android.os.RemoteException;
public int sumarr(int[] arr) throws android.os.RemoteException;
public void doop(com.example.testlib.MyCustomType t, com.example.testlib.IResponseListener resp) throws android.os.RemoteException;
}
