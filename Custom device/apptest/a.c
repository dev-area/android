#include <stdio.h>
#include <linux/ioctl.h>
#include <fcntl.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <string.h>

#include <linux/ion.h>
#include <ion/ion.h>
#include <cutils/log.h>

//#include "ion_test_module.h"

#define TEST_MODULE_NAME    "/dev/vion_dev"
#define DEFAULT_BUF_SIZE    128


int share_with_testdrv(int shared_fd)
{
    int test_fd;
    char buff[DEFAULT_BUF_SIZE] = "ion buffer test magic string";
    int size = 0;
    // TEST_MODULE_NAME : vion_dev 를 open
    test_fd = open(TEST_MODULE_NAME, O_RDWR);

    if (test_fd < 0) {
        printf("Failed to open test driver(vion)\n");
perror("fail:");
        return 0;
    }   
    // register ion client in driver with shared file descriptor
    ioctl(test_fd, 10, &shared_fd);
    // write a string for confirm.
    size = write(test_fd, (char*)buff, DEFAULT_BUF_SIZE - 1); 

    if (size > 0) {
        printf("write \"%s\" string to ion test driver complete\n", buff);
    }   
    // for sync?? 
    printf("sleep 1sec...\n");
    sleep(1);

    close(test_fd);

    return size;
}

int main(int argc, char ** argv)
{
    struct ion_handle *ion_hnd;
    size_t size = DEFAULT_BUF_SIZE;
    int ion_fd, shared_fd, test_fd;
    int ret = 0;
    int write_size = 0;
    unsigned char *confirm_vaddr = NULL;
    // open ion device driver
    ion_fd = ion_open();

    if (ion_fd < 0) {
        printf("Failed to open ion device driver\n");
        ret = ion_fd;
        goto out;
    }
    // allocation ion buffer with ION_HEAP_SYSTEM_CONTIG type.
    // ion driver 의 physical address 를 얻어오는 interface(ion_phys()) 는
    // ION_HEAP_SYSTEM 의 memory type은 지원하지 않음.
    ret = ion_alloc(ion_fd, size, 0, ION_HEAP_SYSTEM_CONTIG_MASK,
                    ION_FLAG_CACHED | ION_FLAG_CACHED_NEEDS_SYNC,
                    &ion_hnd );

    if (ret) {
        printf("ion_alloc failed\n");
        goto close_fd;
    }
    // get shared file descriptor
    ret = ion_share(ion_fd, ion_hnd, &shared_fd);

    if (ret) {
        printf("ion_share failed %d\n", ret);
        goto close_ion;
    }
    // open test driver(vion_dev) and write test string.
    write_size = share_with_testdrv(shared_fd);

    if (write_size <= 0) {
        printf("Failed to share with test drv\n");
        goto close_ion;
    }
    // mmap memory with shared file descriptor.
    confirm_vaddr = (unsigned char*)mmap( NULL, size, PROT_READ | PROT_WRITE, MAP_SHARED, shared_fd, 0 );

    if (confirm_vaddr != NULL)
        // check a string which is written in ion test kernel driver.
        printf("confirm_vaddr is not NULL, confirm data string \"%s\"\n", confirm_vaddr);
    else
        printf("mmap failed\n");

    if (confirm_vaddr)
        munmap((void*)confirm_vaddr, size);

    printf("\nion test application terminated.\n");

close_ion:
    ion_free(ion_fd, ion_hnd);
close_fd:
    close(ion_fd);
out:
    return ret;
}

