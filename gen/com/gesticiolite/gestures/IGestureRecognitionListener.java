/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/camille/projects/InteractivSystem/GesticIolite_git/GesticIolite/src/com/gesticiolite/gestures/IGestureRecognitionListener.aidl
 */
package com.gesticiolite.gestures;
public interface IGestureRecognitionListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.gesticiolite.gestures.IGestureRecognitionListener
{
private static final java.lang.String DESCRIPTOR = "com.gesticiolite.gestures.IGestureRecognitionListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.gesticiolite.gestures.IGestureRecognitionListener interface,
 * generating a proxy if needed.
 */
public static com.gesticiolite.gestures.IGestureRecognitionListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.gesticiolite.gestures.IGestureRecognitionListener))) {
return ((com.gesticiolite.gestures.IGestureRecognitionListener)iin);
}
return new com.gesticiolite.gestures.IGestureRecognitionListener.Stub.Proxy(obj);
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
case TRANSACTION_onGestureRecognized:
{
data.enforceInterface(DESCRIPTOR);
com.gesticiolite.gestures.classifier.Distribution _arg0;
if ((0!=data.readInt())) {
_arg0 = com.gesticiolite.gestures.classifier.Distribution.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onGestureRecognized(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onGestureLearned:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onGestureLearned(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onTrainingSetDeleted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onTrainingSetDeleted(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.gesticiolite.gestures.IGestureRecognitionListener
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
@Override public void onGestureRecognized(com.gesticiolite.gestures.classifier.Distribution distribution) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((distribution!=null)) {
_data.writeInt(1);
distribution.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onGestureRecognized, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onGestureLearned(java.lang.String gestureName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(gestureName);
mRemote.transact(Stub.TRANSACTION_onGestureLearned, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onTrainingSetDeleted(java.lang.String trainingSet) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(trainingSet);
mRemote.transact(Stub.TRANSACTION_onTrainingSetDeleted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onGestureRecognized = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onGestureLearned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onTrainingSetDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void onGestureRecognized(com.gesticiolite.gestures.classifier.Distribution distribution) throws android.os.RemoteException;
public void onGestureLearned(java.lang.String gestureName) throws android.os.RemoteException;
public void onTrainingSetDeleted(java.lang.String trainingSet) throws android.os.RemoteException;
}
