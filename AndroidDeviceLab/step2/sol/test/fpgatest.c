#include <stdio.h>
#include <string.h>
#include <errno.h>

#include <libfpga.h>
#include <hardware/hardware.h>

int main (int argc, char* argv[]) { 
  hw_module_t* module;
  int ret = hw_get_module(MYFPGA_HARDWARE_MODULE_ID, (hw_module_t const**)&module);
  if (ret == 0) {
    struct fpga_device_t *dev;
    module->methods->open(module, 0, (struct hw_device_t **) &dev);
    int val = dev->get_value(dev);
    printf("val=%d\n",val);    
    dev->common.close((struct hw_device_t *)dev);
  }
  return ret;
}
