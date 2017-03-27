LOCAL_PATH := $(call my-dir)
  
#
# 3rd party prebuilt AVI library
#
include $(CLEAR_VARS)
  
LOCAL_MODULE := applib
LOCAL_SRC_FILES := libapp.so
  
include $(PREBUILT_SHARED_LIBRARY)