#include <jni.h>

#include "com_example_app2_MainActivity.h"

JNIEXPORT jint JNICALL Java_com_example_app2_MainActivity_add
  (JNIEnv *env, jclass cl, jint a, jint b)
{
	return a+b;
}
