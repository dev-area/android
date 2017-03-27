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

static int fpga_get_value(struct fpga_device_t* dev) {
  return ioctl_fpga(GETVAL, 0);                    
}

static int fpga_set_start(struct fpga_device_t* dev,int start)
{
	return ioctl_fpga(SETSTART, start);
}
static int fpga_set_end(struct fpga_device_t* dev,int end)
{
	return ioctl_fpga(SETSTOP, end);
}
static int fpga_set_intval(struct fpga_device_t* dev,int intval)
{
	return ioctl_fpga(SETINTVAL, intval);
}
static int fpga_wait_for_int(struct fpga_device_t* dev)
{
	return ioctl_fpga(WAITFORINT, 0);
}

int fpga_get_int_count(struct fpga_device_t* dev)
{
	return ioctl_fpga(GETINTCOUNT, 0);
}	


static int close_fpga(struct fpga_device_t* dev) {
 
  return 0;
}





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
                                                 
    dev->get_value = fpga_get_value;
    dev->set_start = fpga_set_start;
    dev->set_end = fpga_set_end;
    dev->set_int = fpga_set_intval;
    dev->wait_for_int = fpga_wait_for_int;
    dev->get_int_count = fpga_get_int_count;



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
















