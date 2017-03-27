LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under,.)
LOCAL_REQUIRED_MODULES := com.android.fibservice 
LOCAL_JAVA_LIBRARIES := com.android.fibservice \
	core \
	framework
LOCAL_PACKAGE_NAME := FibServiceApp
LOCAL_SDK_VERSION := current
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)
