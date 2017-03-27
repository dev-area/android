#include <jni.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "com_example_testjni_Nlib.h"

jobject m1;

JNIEXPORT jint JNICALL Java_com_example_testjni_Nlib_add
  (JNIEnv *env, jclass cl, jint a, jint b)
{
	int fd=open("/dev/abc",O_RDWR);
	m1=cl;
	return a+b;
}

JNIEXPORT jint JNICALL Java_com_example_testjni_Nlib_sub
  (JNIEnv *env, jobject obj, jint a, jint b)
{
	jclass cl=env->GetObjectClass(obj);

	jmethodID m=env->GetMethodID(cl,"getNum","(I)I");

	jint num=env->CallIntMethod(obj,m,a+b);

	return num;

}








