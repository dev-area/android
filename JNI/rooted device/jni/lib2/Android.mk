LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := mytest
LOCAL_SRC_FILES := ../mytest.cpp

include $(BUILD_SHARED_LIBRARY)
