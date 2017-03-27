LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := testJNI
LOCAL_SRC_FILES := testJNI.cpp 

include $(BUILD_SHARED_LIBRARY)
