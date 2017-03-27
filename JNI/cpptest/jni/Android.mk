LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := cpptest
LOCAL_SRC_FILES := cpptest.cpp

LOCAL_LDLIBS += -llog  

include $(BUILD_SHARED_LIBRARY)
