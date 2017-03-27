#include <jni.h>
#include <sys/mman.h>


static int *map;

static void setNum(JNIEnv *env, jobject thiz, jint pos,jint num)
{

}
static jint getNum(JNIEnv *env, jobject thiz, jint pos)
{
	return map[pos];
}



static void init(JNIEnv *env, jobject thiz, jint fd)
{
	map = (int *)mmap(0,4096,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
}


	static JNINativeMethod method_table[] = {
			{ "setNum", "(II)V", (void *) setNum },
			{ "getNum", "(I)I", (void *) getNum },
			{ "init", "(I)V", (void *)init }

	};


extern "C" jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    } else {
    	jclass clazz = env->FindClass("com/bina/shmclient/ShmClientLib");
    	if (clazz) {
    		jint ret = env->RegisterNatives(clazz, method_table, sizeof(method_table) / sizeof(method_table[0]));
    		env->DeleteLocalRef(clazz);
    		return ret == 0 ? JNI_VERSION_1_6 : JNI_ERR;
    	} else {
    		return JNI_ERR;
    	}
    }
}
