LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ShmClient
LOCAL_SRC_FILES := ShmClient.cpp

include $(BUILD_SHARED_LIBRARY)
