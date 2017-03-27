LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES:=test.cpp
LOCAL_SHARED_LIBRARIES:=libSampClient
LOCAL_MODULE_TAGS:=optional
LOCAL_MODULE:=clientapp
include $(BUILD_EXECUTABLE)
