LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := fpgajni.cpp
LOCAL_C_INCLUDES += $(JNI_H_INCLUDE) $(LOCAL_PATH)/../../../include/
LOCAL_CFLAGS += -g -O0
LOCAL_SHARED_LIBRARIES := libhardware libnativehelper
LOCAL_MODULE := libfpga_jni
include $(BUILD_SHARED_LIBRARY)
