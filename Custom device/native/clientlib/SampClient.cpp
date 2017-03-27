#include <binder/IServiceManager.h>
#include <binder/IPCThreadState.h>
#include "SampClient.h"


namespace android
{
	sp<IBinder> SampClient::binder;
	
	int SampClient::add(int a,int b)
	{
		getService();
		Parcel data, reply;
		data.writeInt32(getpid());
		data.writeInt32(a);
		data.writeInt32(b);
		
		binder->transact(OP_ADD, data, &reply);
		int r = reply.readInt32();
		return r;
	}

	int SampClient::sub(int a,int b)
	{
		getService();
		Parcel data, reply;
		data.writeInt32(getpid());
		data.writeInt32(a);
		data.writeInt32(b);
		
		binder->transact(OP_ADD, data, &reply);
		int r = reply.readInt32();
		return r;
	}

	void SampClient::getService()
	{
		sp<IServiceManager> sm = defaultServiceManager();
		binder = sm->getService(String16("samp.native.service"));
	}

}







