LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under,.)
LOCAL_REQUIRED_MODULES := com.android.fpgaservice 
LOCAL_JAVA_LIBRARIES := com.android.fpgaservice \
	core \
	framework
LOCAL_PACKAGE_NAME := FpgaServiceApp
LOCAL_SDK_VERSION := current
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)
