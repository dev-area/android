LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := fibjni.cpp
LOCAL_C_INCLUDES += $(JNI_H_INCLUDE) 
LOCAL_CFLAGS += -g -O0
LOCAL_SHARED_LIBRARIES := libnativehelper
LOCAL_MODULE := libfib_jni
include $(BUILD_SHARED_LIBRARY)
