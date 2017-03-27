LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES:=SampNativeService.cpp
LOCAL_SHARED_LIBRARIES:=libutils libbinder liblog
LOCAL_MODULE_TAGS:=optional
LOCAL_MODULE:=libNativeService
LOCAL_PRELINK_MODULE:=false
include $(BUILD_SHARED_LIBRARY)
