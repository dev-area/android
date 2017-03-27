#include <libfpga.h>
#include <log/log.h>
#include <log/logger.h>
#include <fcntl.h>
#include <poll.h>
#include <errno.h>
#include <sys/ioctl.h>

#define GETVAL		10
#define GETINTCOUNT	50
#define SETSTART	60
#define SETSTOP		70
#define SETINTVAL	80
#define WAITFORINT	100

// Helper function
static int ioctl_fpga(int request, int param) {
  int logfd = open("/dev/myfpga", O_RDWR);
  if (logfd < 0) {
    return -1;
  } else {
    int ret = ioctl(logfd, request, param);
    close(logfd);
    return ret;
  }
}


// TODO: implement the interface




static int open_fpga(const struct hw_module_t *module, char const *name,
   struct hw_device_t **device) {
    struct fpga_device_t *dev = malloc(sizeof(struct fpga_device_t));
    if (!dev) {
      return -ENOMEM;
    }
    memset(dev, 0, sizeof(*dev));
    dev->common.tag = HARDWARE_DEVICE_TAG;
    dev->common.version = 0;
    dev->common.module = (struct hw_module_t *)module;
    dev->common.close = (int (*)(struct hw_device_t *)) close_fpga;

   // TODO: populate dev


    *device = (struct hw_device_t *)dev;
    return 0;

}

static struct hw_module_methods_t fpga_module_methods = {
  .open = open_fpga,
};

struct hw_module_t HAL_MODULE_INFO_SYM = {
  .tag = HARDWARE_MODULE_TAG,
  .version_major = 1,
  .version_minor = 0,
  .id = MYFPGA_HARDWARE_MODULE_ID,
  .name = "fpga module",
  .author = "Mabel Tech.",
  .methods = &fpga_module_methods,
};
