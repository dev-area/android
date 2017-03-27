/**
 * This file is in PUBLIC DOMAIN. You can use it freely. No guarantee.
 * Author: Fan Hongtao <fanhongtao@gmail.com>
 * Date: 2011-06-28
 */

#define LOG_TAG "HelloWorldService"

#include "IHelloWorldService.h"
#include <binder/IServiceManager.h>
#include <utils/String16.h>
#include <utils/Log.h>
#include <string.h>

using namespace android;

void BnHelloWorldService::instantiate() {
    android::defaultServiceManager()->addService(
            IHelloWorldService::descriptor, new BnHelloWorldService());
}

status_t BnHelloWorldService::onTransact(uint32_t code,
            const Parcel &data,
            Parcel *reply,
            uint32_t flags) {

    switch(code) {
        case PRINT: {
            CHECK_INTERFACE(IHelloWorldService, data, reply);
            const char * message = data.readCString();
            print(message);
            return android::NO_ERROR;
        }
        case SAY_HI: {
            CHECK_INTERFACE(IHelloWorldService, data, reply);
            const char * message = data.readCString();
            char response[128];
            sayHi(message, response);
            reply->writeCString(response);  // write response to client
            return android::NO_ERROR;
        }
        default: {
            return BBinder::onTransact(code, data, reply, flags);
        }
    }
    return android::NO_ERROR;    
}

void BnHelloWorldService::print(const char * message) {
    printf("Receive string: %s\n", message);
}

void BnHelloWorldService::sayHi(const char * message, char * response) {
     printf("%s\n", message);

    strcpy(response, "Hi, I'm hello-world service");
}







