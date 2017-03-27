#include <jni.h>
#include "JNIHelp.h"

static const char * class_name = "com/android/fibappservice/IFibServiceImpl";

static jlong fib(jint n) {
	return n <= 0 ? 0 : n == 1 ? 1 : fib(n - 1) + fib(n - 2);
}
static jlong fibNR(JNIEnv *env, jclass clazz, jint n) {
	return fib(n);
}

static jlong fibNI(JNIEnv *env, jclass clazz, jint n) {
	jlong previous = -1;
	jlong result = 1;
	jlong i;
	for (i = 0; i <= n; i++) {
		jlong sum = result + previous;
		previous = result;
		result = sum;
	}
	return result;
}


static JNINativeMethod method_table[] = {
  { "fibNI", "(I)J", (void *) fibNI},
  { "fibNR", "(I)J", (void *) fibNR},
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
