#include <jni.h>
#include <libfpga.h>
#include <hardware/hardware.h>
#include "JNIHelp.h"

static const char * class_name = "com/android/fpgaappservice/IFpgaServiceImpl";

static jint getval(JNIEnv *env, jobject object) {
  hw_module_t* module;
  int ret = hw_get_module(MYFPGA_HARDWARE_MODULE_ID, (hw_module_t const**)&module);
  if (ret == 0) {
    struct fpga_device_t *dev;
    module->methods->open(module, 0, (struct hw_device_t **) &dev);
    int val = dev->get_value(dev);
    return val+100; 
  }
return 0;
}

static JNINativeMethod method_table[] = {
  { "getVal", "()I", (void *) getval},
};


extern "C" jint JNI_OnLoad(JavaVM* vm, void* reserved) {
  JNIEnv* env = NULL;
  if (vm->GetEnv((void**) &env, JNI_VERSION_1_6) == JNI_OK) {
    if (jniRegisterNativeMethods(env, class_name, method_table, NELEM(method_table)) == 0) {
      return JNI_VERSION_1_6;
    }
  }
  return JNI_ERR;
}
