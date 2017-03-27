#ifndef ANDROID_NATIVESERVICE_H
#define ANDROID_NATIVESERVICE_H

#include <utils/RefBase.h>
#include <binder/IInterface.h>
#include <binder/Parcel.h>

namespace android
{
	class SampNativeService : public BBinder
	{
	private:
		enum {OP_ADD, OP_SUB};
		int add(int a,int b){return a+b;}
		int sub(int a,int b){return a-b;}

	public:
		static int Instance();
		virtual status_t onTransact(uint32_t, const Parcel&, Parcel*, uint32_t);
	};
}

#endif
