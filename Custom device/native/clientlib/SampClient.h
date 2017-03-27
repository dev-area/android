#ifndef ANDROID_SAMPCLIENT_H
#define ANDROID_SAMPCLIENT_H
#include <binder/IServiceManager.h>
#include <binder/IPCThreadState.h>

namespace android
{
	class SampClient
	{
	public:
		enum {OP_ADD, OP_SUB};
		int add(int a,int b);
		int sub(int a,int b);
	private:
		static sp<IBinder> binder;
		static void getService();
	};
}

#endif
