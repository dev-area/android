#include <jni.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <sys/mman.h>


#define ASHMEM_NAME_LEN         256
#define __ASHMEMIOC             0x77
#define ASHMEM_SET_NAME         _IOW(__ASHMEMIOC, 1, char[ASHMEM_NAME_LEN])
#define ASHMEM_SET_SIZE         _IOW(__ASHMEMIOC, 3, size_t)

static int *map;

static void setNum(JNIEnv *env, jobject thiz, jint pos,jint num)
{

}
static jint getNum(JNIEnv *env, jobject thiz, jint pos)
{
	return 0;
}



static jint getFD(JNIEnv *env, jobject thiz, jstring path)
{
	const char *name = env->GetStringUTFChars(path,NULL);

	jint fd = open("/dev/ashmem",O_RDWR);

	ioctl(fd,ASHMEM_SET_NAME,name);

	ioctl(fd,ASHMEM_SET_SIZE,4096);


	map = (int *)mmap(0,4096,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
	map[0]=99;
	map[10]=88;

	env->ReleaseStringUTFChars(path,name);

	return fd;
//	 jobject fileDescriptor = jniCreateFileDescriptor(env, fd);


}


	static JNINativeMethod method_table[] = {
			{ "setNum", "(II)V", (void *) setNum },
			{ "getNum", "(I)I", (void *) getNum },
			{ "getFD", "(Ljava/lang/String;)I", (void *)getFD }

	};


extern "C" jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    } else {
    	jclass clazz = env->FindClass("com/bina/utils/ShmLib");
    	if (clazz) {
    		jint ret = env->RegisterNatives(clazz, method_table, sizeof(method_table) / sizeof(method_table[0]));
    		env->DeleteLocalRef(clazz);
    		return ret == 0 ? JNI_VERSION_1_6 : JNI_ERR;
    	} else {
    		return JNI_ERR;
    	}
    }
}
