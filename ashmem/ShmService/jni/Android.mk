LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Shm
LOCAL_SRC_FILES := Shm.cpp

include $(BUILD_SHARED_LIBRARY)
