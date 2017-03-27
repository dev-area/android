#include <binder/IServiceManager.h>
#include <binder/IPCThreadState.h>
#include "SampNativeService.h"

namespace android
{
	
	int SampNativeService::Instance()
	{
		int ret = defaultServiceManager()->addService(
				String16("samp.native.service"), new SampNativeService());
		return ret;
	}

	status_t SampNativeService::onTransact(uint32_t code, const Parcel& data, Parcel* reply, uint32_t flags)
	{
		switch(code)
		{
		case OP_ADD: 
			{
				pid_t pid = data.readInt32();
				int num1 = data.readInt32();
				int num2 = data.readInt32();
				int res = add(num1,num2);
				reply->writeInt32(res);
				return NO_ERROR;
			} 
			break;
		case OP_SUB: 
			{
				pid_t pid = data.readInt32();
				int num1 = data.readInt32();
				int num2 = data.readInt32();
				int res = sub(num1,num2);
				reply->writeInt32(res);
				return NO_ERROR;
			} 
			break;
		default:
			return BBinder::onTransact(code, data, reply, flags);
		}
	}
}
