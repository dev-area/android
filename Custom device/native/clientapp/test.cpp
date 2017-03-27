#include <stdio.h>
#include "../clientlib/SampClient.h"

using namespace android;

int main(int argc, char** argv)
{
	SampClient client;
	int ret = client.add(200,120);
	printf("add return: %d\n", ret);
	return 0;
}
