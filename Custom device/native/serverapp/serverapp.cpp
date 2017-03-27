#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <grp.h>
#include <binder/IPCThreadState.h>
#include <binder/ProcessState.h>
#include <binder/IServiceManager.h>
#include <utils/Log.h>
#include "../service/SampNativeService.h"

using namespace android;


int main(int arg, char** argv)
{
	printf("server begin\n");
	sp<ProcessState> proc(ProcessState::self());
	sp<IServiceManager> sm = defaultServiceManager();
	printf("server - ServiceManager: %p\n", sm.get());
	int ret = SampNativeService::Instance();
	printf("server - SampNativeService::Instance return %d\n", ret);
	ProcessState::self()->startThreadPool();
	IPCThreadState::self()->joinThreadPool();
}
