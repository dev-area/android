LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES:=serverapp.cpp
LOCAL_SHARED_LIBRARIES:=libutils libbinder libNativeService
LOCAL_MODULE_TAGS:=optional
LOCAL_MODULE:=serverapp
include $(BUILD_EXECUTABLE)
