#include <jni.h>
#include <pthread.h>
#include <android/log.h>


static JavaVM* javaVM;
static jclass cl;

namespace com_example_cpptest {

	static jlong fib(jlong n) {
		return n <= 0 ? 0 : n == 1 ? 1 : fib(n - 1) + fib(n - 2);
	}

	static void *threadfn(void *p)
	{
		jlong res = fib((long)p);
		JNIEnv *env;
		int n=javaVM->AttachCurrentThread(&env,NULL);

		jmethodID m=env->GetStaticMethodID(cl,"printToLog","(J)V");

		env->CallStaticVoidMethod(cl,m,res);

		javaVM->DetachCurrentThread();
		return (void*)res;
	}


	static jlong fibNR11(JNIEnv *env, jclass clazz, jlong n) {
		pthread_t t1;
		pthread_create(&t1,NULL,threadfn,(void*)n);
		return 0;
	}

	static jlong fibNI(JNIEnv *env, jclass clazz, jlong n) {
		jlong previous = -1;
		jlong result = 1;
		jlong i;
		__android_log_print(ANDROID_LOG_DEBUG, "FibLib.c", "fibNI(%lld)", n);
		for (i = 0; i <= n; i++) {
			jlong sum = result + previous;
			previous = result;
			result = sum;
		}
		return result;
	}

	static jobject getBuffer(JNIEnv *env, jclass clazz)
	{
		char *buf=(char *)malloc(1000);
		buf[10]=20;
		return env->NewDirectByteBuffer((void*)buf,1000);
	}

	static JNINativeMethod method_table[] = {
			{ "fibNR", "(J)J", (void *) fibNR11 },
			{ "fibNI", "(J)J", (void *) fibNI },
			{ "getBuf","()Ljava/nio/ByteBuffer;",  (void *) getBuffer }
	};
}

using namespace com_example_cpptest;

jint JNI_OnLoad(JavaVM* vm, void* reserved) {
	JNIEnv* env;
	javaVM = vm;
	if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    } else {
    	jclass clazz = env->FindClass("com/example/cpptest/FibLib");
    	cl = (jclass)env->NewGlobalRef(clazz);
    	if (clazz) {
    		jint ret = env->RegisterNatives(clazz, method_table, sizeof(method_table) / sizeof(method_table[0]));
    		env->DeleteLocalRef(clazz);
    		return ret == 0 ? JNI_VERSION_1_6 : JNI_ERR;
    	} else {
    		return JNI_ERR;
    	}
    }
}
